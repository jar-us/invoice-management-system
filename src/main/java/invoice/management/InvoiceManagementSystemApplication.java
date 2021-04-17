package invoice.management;

import invoice.management.dto.Customer;
import invoice.management.dto.Invoice;
import invoice.management.dto.Merchant;
import invoice.management.dto.Product;
import invoice.management.repo.CustomerRepo;
import invoice.management.repo.InvoiceRepo;
import invoice.management.repo.MerchantRepo;
import invoice.management.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
@ComponentScan("invoice.management")
public class InvoiceManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Autowired
    private MerchantRepo merchantRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;


    public static void main(String[] args) {
        SpringApplication.run(InvoiceManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Invoice invoice = new Invoice();

        Merchant merchant = new Merchant();
        merchant.setName("Suraj");

        Customer customer = new Customer();
        customer.setName("Amit");

        Product bsnlProduct = new Product();
        bsnlProduct.setName("bsnl");

        Product railway = new Product();
        railway.setName("railway");

        HashSet<Product> products = new HashSet<>();
        products.add(bsnlProduct);
        products.add(railway);


        invoice.setMerchant(merchant);
        invoice.setCustomer(customer);
        invoice.setProducts(products);


        productRepo.save(bsnlProduct);
        productRepo.save(railway);

        merchantRepo.save(merchant);
        customerRepo.save(customer);
        invoiceRepo.save(invoice);


//        Invoice invoice1 = new Invoice();
//        invoice1.setMerchant(merchant);
//        invoiceRepo.save(invoice1);
    }
}
