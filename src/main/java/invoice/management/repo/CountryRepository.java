package invoice.management.repo;

import invoice.management.dto.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    Country save(Country country);
}
