package invoice.management.utility;

import invoice.management.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static invoice.management.constants.MerchantRequestAttributes.*;
import static invoice.management.constants.MerchantRequestAttributes.DATE;

public class CreateInvoiceRequestParser {

    public static InvoiceModel convertRequestPayloadIntoInvoiceModel(CreateInvoiceRequest request) {
        Optional.of(request.getInvoice()).orElseThrow(() -> new RuntimeException("invoice is missing in request payload"));
        Optional.of(request.getInvoicer()).orElseThrow(() -> new RuntimeException("invoicer is missing in request payload"));
        Optional.of(request.getRecipient()).orElseThrow(() -> new RuntimeException("Recipient is missing in request payload"));

        InvoiceModel invoiceModel = new InvoiceModel();

        invoiceModel.setDetails(getInvoiceDetailModel(request));
        invoiceModel.setInvoicer(getInvoicerModel(request.getInvoicer()));
        invoiceModel.setRecipient(prepareRecipientModel(request));
        invoiceModel.setItems(getItems(request.getItems()));
        return invoiceModel;
    }

    private static InvoicerModel getInvoicerModel(Map<String, Object> invoicer) {
        InvoicerModel invoicerModel = new InvoicerModel();
        Integer invoicerId = (Integer) invoicer.get(ID.label);
        invoicerModel.setId(Long.parseLong(Integer.toString(invoicerId)));
        return invoicerModel;
    }

    private static InvoiceDetailModel getInvoiceDetailModel(CreateInvoiceRequest request) {
        InvoiceDetailModel detail = new InvoiceDetailModel();
        detail.setCreatedDate(getInvoiceCreatedDate(request.getInvoice()));
        return detail;
    }

    private static RecipientModel prepareRecipientModel(CreateInvoiceRequest request) {
        RecipientModel recipient = new RecipientModel();
        recipient.setFirstName(getRecipientName(request.getRecipient(), FIRST.label));
        recipient.setLastName(getRecipientName(request.getRecipient(), LAST.label));
        recipient.setAddresses(getRecipientAddresses(request.getRecipient()));
        recipient.setContacts(getRecipientContacts(request.getRecipient()));
        return recipient;
    }

    private static List<ItemModel> getItems(List<Map<String, Object>> contacts) {
        List<ItemModel> items = contacts.stream().map(itemMap -> {
            String name = (String) itemMap.get(NAME.label);
            ItemModel item = new ItemModel();
            item.setName(name);
            return item;
        }).collect(Collectors.toList());
        return items;
    }

    private static List<ContactModel> getRecipientContacts(Recipient recipient) {
        List<ContactModel> contacts = recipient.getContacts().stream().map(contactMap -> {
            Integer phone = (Integer) contactMap.get(PHONE.label);
            ContactModel contact = new ContactModel();
            contact.setPhone(phone);
            return contact;
        }).collect(Collectors.toList());
        return contacts;
    }

    private static List<AddressModel> getRecipientAddresses(Recipient recipient) {
        List<AddressModel> addresses = recipient.getAddresses().stream().map(addressMap -> {
            String street = (String) addressMap.get(STREET.label);
            String country = (String) addressMap.get(COUNTRY.label);
            AddressModel address = new AddressModel();
            address.setStreet(street);
            address.setStreet(country);
            return address;
        }).collect(Collectors.toList());
        return addresses;
    }

    private static String getRecipientName(Recipient recipient, String label) {
        return (String) recipient.getNames().get(label);
    }

    private static LocalDate getInvoiceCreatedDate(Map<String, Object> invoice) {
        String invoicedDate = (String) invoice.get(DATE.label);
        return LocalDate.parse(invoicedDate, DateTimeFormatter.ofPattern("[yyyy-MM-dd]"));
    }

}
