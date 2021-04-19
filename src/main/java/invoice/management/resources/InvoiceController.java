package invoice.management.resources;

import invoice.management.model.*;
import invoice.management.services.InvoiceService;
import invoice.management.utility.CreateInvoiceResponseParser;
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
import java.util.Optional;
import java.util.stream.Collectors;

import static invoice.management.constants.MerchantRequestAttributes.*;
import static invoice.management.utility.CreateInvoiceRequestParser.convertRequestPayloadIntoInvoiceModel;

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
        log.info("create invoice request payload:" + request);

        InvoiceModel invoice = convertRequestPayloadIntoInvoiceModel(request);
        invoice = service.createInvoice(invoice);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CreateInvoiceResponseParser.createInvoiceResponse(invoice));
    }


}
