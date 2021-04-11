package invoice.management.repo;

import invoice.management.dto.City;
import invoice.management.dto.InvoiceState;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceStateRepository extends CrudRepository<InvoiceState, Integer> {

}
