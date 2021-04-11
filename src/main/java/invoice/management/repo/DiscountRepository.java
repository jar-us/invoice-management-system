package invoice.management.repo;

import invoice.management.dto.Discount;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<Discount, Integer> {

    Discount save(Discount discount);


}
