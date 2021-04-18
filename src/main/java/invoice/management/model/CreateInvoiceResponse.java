package invoice.management.model;

import invoice.management.dto.Invoice;
import lombok.Data;

import java.util.Map;

@Data
public class CreateInvoiceResponse {
////    private Map<String, Object> details;
//    private Long id;
//    private String message;

//    private Invoice invoice;

    private InvoiceModel invoice;
}
