package invoice.management.utility;

import invoice.management.constants.MerchantRequestAttributes;
import invoice.management.model.Address;
import invoice.management.model.Contact;
import invoice.management.model.MerchantModel;
import invoice.management.model.RegisterMerchantRequest;

import java.util.List;
import java.util.stream.Collectors;

public class MerchantJsonToModelConverter {
    public static MerchantModel getMerchantObject(RegisterMerchantRequest request) {
        String firstName = (String) request.getMerchant().get(MerchantRequestAttributes.FIRST_NAME.label);
        String lastName = (String) request.getMerchant().get(MerchantRequestAttributes.LAST_NAME.label);

        List<Address> addresses = request.getAddresses().stream().map(addressMap -> {
            String street = (String) addressMap.get(MerchantRequestAttributes.STREET.label);
            Address address = new Address();
            address.setStreet(street);
            return address;
        }).collect(Collectors.toList());

        List<Contact> contacts = request.getContacts().stream().map(contactMap -> {
            Integer phone = (Integer) contactMap.get(MerchantRequestAttributes.PHONE.label);
            Contact contact = new Contact();
            contact.setPhone(phone);
            return contact;
        }).collect(Collectors.toList());

        MerchantModel merchantModel = new MerchantModel();
        merchantModel.setFirstName(firstName);
        merchantModel.setLastName(lastName);
        merchantModel.setAddresses(addresses);
        merchantModel.setContacts(contacts);

        return merchantModel;
    }

}
