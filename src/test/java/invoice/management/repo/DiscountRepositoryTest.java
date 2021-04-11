package invoice.management.repo;

import invoice.management.dto.Discount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Rollback(value = false)
class DiscountRepositoryTest {

    @Autowired
    private DiscountRepository repository;

    @Test
    public void test_save_discount() {
        Discount discount = new Discount();
        discount.setName("Diwali Offer");
        discount.setPercent(11.11f);

        Discount savedDiscount = repository.save(discount);

        assertThat(savedDiscount.getId()).isEqualTo(1);
    }
}