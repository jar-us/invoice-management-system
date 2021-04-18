package invoice.management.services;

import invoice.management.dto.Customer;
import invoice.management.dto.Invoice;
import invoice.management.dto.Merchant;
import invoice.management.dto.Product;
import invoice.management.model.InvoiceModel;
import invoice.management.model.InvoicerModel;
import invoice.management.model.ItemModel;
import invoice.management.model.RecipientModel;
import invoice.management.repo.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public InvoiceModel createInvoice(InvoiceModel invoiceModel){

        Invoice invoice = repository.saveInvoice(invoiceModel);
        populateInvoiceModel(invoice, invoiceModel);
        System.out.println(invoice);

        return invoiceModel;
    }

    private void populateInvoiceModel(Invoice invoice, InvoiceModel invoiceModel) {

        invoiceModel.setInvoiceId(invoice.getId());
        invoiceModel.setInvoicer(getInvoicer(invoice.getMerchant()));
//        invoiceModel.setDetails(getInvoiceDetails(invoice.get));
        invoiceModel.setRecipient(getRecipient(invoice.getCustomer()));
        invoiceModel.setItems(getItems(invoice.getProducts()));
    }

    private List<ItemModel> getItems(Set<Product> products) {
        List<ItemModel> items = products.stream().map(product -> {
            ItemModel itemModel = new ItemModel();
            itemModel.setName(product.getName());
            return itemModel;
        }).collect(Collectors.toList());
        return items;
    }

    private RecipientModel getRecipient(Customer customer) {
        RecipientModel recipientModel = new RecipientModel();
        recipientModel.setId(customer.getCustomerId());
        recipientModel.setFirstName(customer.getFirstName());
        recipientModel.setLastName(customer.getLastName());
//        recipientModel.setAddresses(customer.get);
        return recipientModel;
    }

    private InvoicerModel getInvoicer(Merchant merchant) {
        InvoicerModel invoicerModel = new InvoicerModel();
        invoicerModel.setId(merchant.getId());
        invoicerModel.setFirstName(merchant.getFirstName());
        invoicerModel.setLastName(merchant.getLastName());
        return invoicerModel;
    }

}
