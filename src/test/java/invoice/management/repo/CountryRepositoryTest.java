package invoice.management.repo;


import invoice.management.dto.City;
import invoice.management.dto.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback(value = false)
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository repository;

    @Test
    public void test_save_country() {
        Country country = new Country();
        country.setName("India");
        Country savedCountry = repository.save(country);

        assertThat(savedCountry.getId()).isEqualTo(1);
    }
}
