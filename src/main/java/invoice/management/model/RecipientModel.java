package invoice.management.model;

import lombok.Data;

import java.util.List;

@Data
public class RecipientModel {
    private Long id;
    private String firstName;
    private String lastName;
    private List<AddressModel> addresses;
    private List<ContactModel> contacts;

}
