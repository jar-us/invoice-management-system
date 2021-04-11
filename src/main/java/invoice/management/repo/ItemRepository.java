package invoice.management.repo;

import invoice.management.dto.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {



}
