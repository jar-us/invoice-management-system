package invoice.management.repo;

import invoice.management.dto.Tax;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Rollback(value = false)
class TaxRepositoryTest {

    @Autowired
    private TaxRepository repository;

    @Test
    public void test_save_tax() {
        Tax tax = new Tax();
        tax.setName("GST");
        tax.setPercent(100.001f);

        Tax savedTax = repository.save(tax);

        assertThat(savedTax.getId()).isEqualTo(1);


    }

}