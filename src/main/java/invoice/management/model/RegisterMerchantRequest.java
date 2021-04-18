package invoice.management.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RegisterMerchantRequest {
    private Map<String, Object> merchant;
    private List<Map<String, Object>> addresses;
    private List<Map<String, Object>> contacts;
}
