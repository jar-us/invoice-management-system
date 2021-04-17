package invoice.management.services;

import invoice.management.model.CreateInvoiceRequest;
import invoice.management.model.ServiceCreateRequest;
import invoice.management.model.ServiceCreateResponse;
import invoice.management.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    public ServiceCreateResponse createInvoice(ServiceCreateRequest request){
        InvoiceObj invoiceObj = getInvoiceObjectFromRequest(request);
        InvoicerObj invoicerObj = getInvoicerObjectFromRequest(request);
        RecipentObj recipentObj = getRecipentObjectFromRequest(request);
        List<InvoiceItem> items = getItemsObjectFromRequest(request);
        return null;
    }

}
