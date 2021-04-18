package invoice.management.repo;

import invoice.management.dto.Customer;
import invoice.management.dto.Invoice;
import invoice.management.dto.Merchant;
import invoice.management.dto.Product;
import invoice.management.model.InvoiceModel;
import invoice.management.model.InvoicerModel;
import invoice.management.model.ItemModel;
import invoice.management.model.RecipientModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class InvoiceRepository {

    private InvoiceRepo invoiceRepo;
    private CustomerRepo customerRepo;
    private MerchantRepo merchantRepo;
    private ProductRepo productRepo;

    public InvoiceRepository(InvoiceRepo invoiceRepo, CustomerRepo customerRepo, MerchantRepo merchantRepo, ProductRepo productRepo) {
        this.invoiceRepo = invoiceRepo;
        this.customerRepo = customerRepo;
        this.merchantRepo = merchantRepo;
        this.productRepo = productRepo;
    }

    public Invoice saveInvoice(InvoiceModel invoiceModel) {

        // find merchant by invoicerId
        // if merchant is present : search customer by phone number : if customer is present then get customer id. If not present then save customer and get customerId
        // if merchant is not present : throw exception - invalid invoicer

        Merchant merchant = merchantRepo.findById(invoiceModel.getInvoicer().getId()).orElseThrow(() -> new RuntimeException("invalid invoicer"));

//        invoiceModel
//                .getRecipient()
//                .getContacts()
//                .stream()
//                .map(contact ->
//                {
//                    Optional<Customer> byPhone = customerRepo.findByPhone(contact.getPhone());
//                    if (byPhone.isPresent()) {
//                        return byPhone.get();
//                    } else {
//                        Customer savedCustomer = customerRepo.save(convertRecipientToCustomer(contact));
//                        return savedCustomer;
//                    }
//                });

        Customer customer = customerRepo.save(convertRecipientToCustomer(invoiceModel.getRecipient()));

        List<Product> products = productRepo.saveAll(convertItemsToProduct(invoiceModel.getItems()));


        Invoice savedInvoice = invoiceRepo.save(
                prepareInvoice(invoiceModel, merchant, customer, products)
        );


        return savedInvoice;
    }

    private Invoice prepareInvoice(InvoiceModel invoiceModel, Merchant merchant, Customer customer, List<Product> products) {

        Invoice invoice = new Invoice();

        invoice.setMerchant(merchant);
        invoice.setCustomer(customer);
        invoice.setProducts(products.stream().collect(Collectors.toSet()));

        return invoice;

    }

    private Set<Product> convertItemsToProduct(List<ItemModel> items) {

        Set<Product> products = items.stream().map(item -> {
            Product product = new Product();
            product.setName(item.getName());
            return product;
        }).collect(Collectors.toSet());

        return products;

    }

    private Customer convertRecipientToCustomer(RecipientModel recipient) {
        Customer customer = new Customer();
        customer.setFirstName(recipient.getFirstName());
        customer.setLastName(recipient.getLastName());
        return customer;
    }

    private void convertInvoicerToMerchant(InvoicerModel invoicer) {

    }


}
