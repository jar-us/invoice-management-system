package invoice.management.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RegisterMerchantResponse {
    // return full merchant object with id
//    private Map<String, Object> merchantDetails;
//    private List<Map<String, Object>> addresses;
//    private List<Map<String, Object>> contacts;

    private MerchantModel merchantModel;
}
