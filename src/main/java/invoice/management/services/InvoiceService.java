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
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static invoice.management.utility.InvoiceToInvoiceModelConverter.populateInvoiceModel;

@Log4j2
@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public InvoiceModel createInvoice(InvoiceModel invoiceModel){
        Invoice invoice = repository.saveInvoice(invoiceModel);
        populateInvoiceModel(invoice, invoiceModel);
        return invoiceModel;
    }


}
