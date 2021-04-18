package invoice.management.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CreateInvoiceRequest {
    private Map<String, Object> invoice;
//    private Invoicer invoicer;
    private Map<String, Object> invoicer;
    private Recipient recipient;
    private List<Map<String, Object>> items;
}
