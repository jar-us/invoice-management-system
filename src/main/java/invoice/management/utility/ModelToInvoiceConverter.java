package invoice.management.utility;

import invoice.management.dto.Customer;
import invoice.management.dto.Invoice;
import invoice.management.dto.Merchant;
import invoice.management.dto.Product;
import invoice.management.model.InvoiceModel;
import invoice.management.model.ItemModel;
import invoice.management.model.RecipientModel;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelToInvoiceConverter {
    public static Invoice prepareInvoice(InvoiceModel invoiceModel, Merchant merchant, Customer customer, List<Product> products) {
        Invoice invoice = new Invoice();
        invoice.setMerchant(merchant);
        invoice.setCustomer(customer);
        invoice.setProducts(products.stream().collect(Collectors.toSet()));
        return invoice;
    }

    public static Set<Product> convertItemsToProduct(List<ItemModel> items) {
        Set<Product> products = items.stream().map(item -> {
            Product product = new Product();
            product.setName(item.getName());
            return product;
        }).collect(Collectors.toSet());
        return products;
    }

    public static Customer convertRecipientToCustomer(RecipientModel recipient) {
        Customer customer = new Customer();
        customer.setFirstName(recipient.getFirstName());
        customer.setLastName(recipient.getLastName());
        return customer;
    }

}
