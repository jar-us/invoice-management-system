package invoice.management.utility;

import invoice.management.model.CreateInvoiceResponse;
import invoice.management.model.InvoiceModel;

public class CreateInvoiceResponseParser {
    public static CreateInvoiceResponse createInvoiceResponse(InvoiceModel invoiceModel) {
        CreateInvoiceResponse createInvoiceResponse = new CreateInvoiceResponse();
        createInvoiceResponse.setInvoice(invoiceModel);
        return createInvoiceResponse;
    }
}
