package invoice.management.resources;

import invoice.management.dto.Invoice;
import invoice.management.model.*;
import invoice.management.services.InvoiceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static invoice.management.constants.MerchantRequestAttributes.*;

@Log4j2
@RestController
@RequestMapping("/ims")
public class InvoiceController {

    private InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping("/invoices")
    public ResponseEntity<CreateInvoiceResponse> createInvoice(@RequestBody CreateInvoiceRequest request) {
        log.info("create request received:" + request);



        InvoiceModel invoice = getinvoiceFromRequestJson(request);

        System.out.println("invoiceModel =>"+invoice);
        invoice = service.createInvoice(invoice);
        System.out.println(invoice);


        CreateInvoiceResponse createInvoiceResponse = new CreateInvoiceResponse();
//        createInvoiceResponse.setDetails(Map.of("name", "invoice created"));
//        createInvoiceResponse.setId(invoice.getInvoiceId());
//        createInvoiceResponse.setMessage("Congrats Invoice Created!");
        createInvoiceResponse.setInvoice(invoice);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(createInvoiceResponse);
    }

    private InvoiceModel getinvoiceFromRequestJson(CreateInvoiceRequest request) {
        String invoicedDate = (String) request.getInvoice().get(DATE.label);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("[yyyy-MM-dd]");
        LocalDate date = LocalDate.parse(invoicedDate, dateFormat);


        Integer invoicerId = (Integer) request.getInvoicer().get(ID.label);

        String recipientFirstName = (String) request.getRecipient().getNames().get(FIRST.label);
        String recipentLastName = (String) request.getRecipient().getNames().get(LAST.label);

        List<AddressModel> addresses = request.getRecipient().getAddresses().stream().map(addressMap -> {
            String street = (String) addressMap.get(STREET.label);
            String country = (String) addressMap.get(COUNTRY.label);
            AddressModel address = new AddressModel();
            address.setStreet(street);
            address.setStreet(country);
            return address;
        }).collect(Collectors.toList());

        List<ContactModel> contacts = request.getRecipient().getContacts().stream().map(contactMap -> {
            Integer phone = (Integer) contactMap.get(PHONE.label);
            ContactModel contact = new ContactModel();
            contact.setPhone(phone);
            return contact;
        }).collect(Collectors.toList());

        List<ItemModel> items = request.getItems().stream().map(itemMap -> {
            String name = (String) itemMap.get(NAME.label);
            ItemModel item = new ItemModel();
            item.setName(name);
            return item;
        }).collect(Collectors.toList());


        InvoiceModel invoice = new InvoiceModel();

        InvoiceDetailModel detail = new InvoiceDetailModel();
        detail.setCreatedDate(date);

        RecipientModel recipient = new RecipientModel();
        recipient.setFirstName(recipientFirstName);
        recipient.setLastName(recipentLastName);
        recipient.setAddresses(addresses);
        recipient.setContacts(contacts);

        InvoicerModel invoicer = new InvoicerModel();
        invoicer.setId(Long.parseLong(Integer.toString(invoicerId)));

        invoice.setDetails(detail);
        invoice.setInvoicer(invoicer);
        invoice.setRecipient(recipient);
        invoice.setItems(items);

        return invoice;

    }


}
