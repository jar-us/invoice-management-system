package invoice.management.model;

import lombok.Data;

import java.util.List;

@Data
public class MerchantModel {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Address> addresses;
    private List<Contact> contacts;

}
