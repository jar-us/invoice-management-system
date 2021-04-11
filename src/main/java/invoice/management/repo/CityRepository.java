package invoice.management.repo;

import invoice.management.dto.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {

    City save(City city);


}
