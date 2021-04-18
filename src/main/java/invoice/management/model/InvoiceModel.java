package invoice.management.model;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceModel {
    private Long invoiceId;
    private InvoicerModel invoicer;
    private InvoiceDetailModel details;
    private RecipientModel recipient;
    private List<ItemModel> items;

}
