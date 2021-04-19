package invoice.management.repo;

import invoice.management.dto.Invoice;
import invoice.management.dto.Merchant;
import org.assertj.core.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class InvoiceRepoTest {

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Autowired
    private MerchantRepo merchantRepo;

    @Test
    public void test_save_invoice(){
        Invoice invoice = new Invoice();

        Merchant merchant = new Merchant();
        invoice.setMerchant(merchant);

        merchantRepo.save(merchant);
        Invoice savedInvoice = invoiceRepo.save(invoice);



        System.out.println(savedInvoice);
        Assertions.assertThat(savedInvoice.getId()).isEqualTo(1);


    }
}