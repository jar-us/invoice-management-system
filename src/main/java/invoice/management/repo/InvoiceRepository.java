package invoice.management.repo;

import invoice.management.dto.Customer;
import invoice.management.dto.Invoice;
import invoice.management.dto.Merchant;
import invoice.management.dto.Product;
import invoice.management.model.InvoiceModel;
import invoice.management.model.InvoicerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

import static invoice.management.utility.ModelToInvoiceConverter.*;

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
        Customer customer = customerRepo.save(convertRecipientToCustomer(invoiceModel.getRecipient()));
        List<Product> products = productRepo.saveAll(convertItemsToProduct(invoiceModel.getItems()));
        Invoice savedInvoice = invoiceRepo.save(prepareInvoice(invoiceModel, merchant, customer, products));
        return savedInvoice;
    }

}
