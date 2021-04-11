package invoice.management.repo;


import invoice.management.dto.City;
import invoice.management.repo.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback(value = false)
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void test_save_city() {
        City city = new City();
        city.setName("Bangalore");
        City savedCity = cityRepository.save(city);

        assertThat(savedCity.getId()).isEqualTo(1);
    }
}
