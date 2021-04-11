package invoice.management.repo;

import invoice.management.dto.City;
import invoice.management.dto.Country;
import invoice.management.dto.Customer;
import invoice.management.dto.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback(value = false)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepo;


    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private StateRepository stateRepo;

    @Autowired
    private CountryRepository countryRepo;

    @Test
    public void test_save_customer(){
        City city = new City();
        city.setName("Bangalore");

        State state = new State();
        state.setName("KA");

        Country country = new Country();
        country.setName("IND");

        Customer customer = new Customer();
        customer.setFirstName("Suraj");
        customer.setLastName("Sharma");
        customer.setStreet("#123");

        // set child reference
        customer.setCityId(city);
        customer.setStateId(state);
        customer.setCountryId(country);

        // set parent reference
        city.setCustomer(customer);
        state.setCustomer(customer);
        country.setCustomer(customer);

        // save parent
        City savedCity = cityRepo.save(city);
        State savedState = stateRepo.save(state);
        Country savedCountry = countryRepo.save(country);

        assertThat(savedCity.getId()).isEqualTo(1);
        assertThat(savedState.getId()).isEqualTo(1);
        assertThat(savedCountry.getId()).isEqualTo(1);


    }

}
