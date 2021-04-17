package invoice.management.repo;

import invoice.management.model.SaveInvoice;
import invoice.management.model.SavedInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepository {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public SavedInvoice saveInvoice(SaveInvoice saveInvoice){
        return null;
    }
}
