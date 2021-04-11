package invoice.management.repo;

import invoice.management.dto.InvoiceState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Rollback(value = false)
class InvoiceStateRepositoryTest {

    @Autowired
    private InvoiceStateRepository repository;

    @Test
    public void test_save_invoiceState() {

        InvoiceState invoiceState = new InvoiceState();
        invoiceState.setState("draft");


        InvoiceState savedInvoiceState = repository.save(invoiceState);

        assertThat(savedInvoiceState.getId()).isEqualTo(1);


    }


}