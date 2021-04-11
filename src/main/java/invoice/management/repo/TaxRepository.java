package invoice.management.repo;

import invoice.management.dto.City;
import invoice.management.dto.Tax;
import org.springframework.data.repository.CrudRepository;

public interface TaxRepository extends CrudRepository<Tax, Integer> {

    Tax save(Tax tax);


}
