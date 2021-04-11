package invoice.management.repo;

import invoice.management.dto.PaymentMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Rollback(value = false)
class PaymentModeRepositoryTest {

    @Autowired
    private PaymentModeRepository repository;

    @Test
    public void test_save_Payment() {
        PaymentMode paymentMode = new PaymentMode();
        paymentMode.setName("UPI");

        PaymentMode savedPaymentMode = repository.save(paymentMode);

        assertThat(savedPaymentMode.getId()).isEqualTo(1);

    }

}