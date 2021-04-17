package invoice.management.resources;

import invoice.management.model.CreateInvoiceRequest;
import invoice.management.model.CreateInvoiceResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/ims")
public class InvoiceController {

    @PostMapping("/invoices")
    public ResponseEntity<CreateInvoiceResponse> createInvoice(@RequestBody CreateInvoiceRequest request) {
        log.info("create request received:" + request);

        CreateInvoiceResponse createInvoiceResponse = new CreateInvoiceResponse();
        createInvoiceResponse.setDetails(Map.of("name", "invoice created"));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(createInvoiceResponse);
    }


}
