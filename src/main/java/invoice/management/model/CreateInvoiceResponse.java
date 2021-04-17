package invoice.management.model;

import lombok.Data;

import java.util.Map;

@Data
public class CreateInvoiceResponse {
    private Map<String, Object> details;
}
