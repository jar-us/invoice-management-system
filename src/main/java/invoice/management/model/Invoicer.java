package invoice.management.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Invoicer {
    private Map<String, Object> names;
    private List<Map<String, Object>> addresses;
    private List<Map<String, Object>> contacts;

}
