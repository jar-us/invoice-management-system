package invoice.management.repo;

import invoice.management.dto.PaymentMode;
import org.springframework.data.repository.CrudRepository;

public interface PaymentModeRepository extends CrudRepository<PaymentMode, Integer> {

    PaymentMode save(PaymentMode paymentMode);


}
