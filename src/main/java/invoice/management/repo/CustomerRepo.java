package invoice.management.repo;

import invoice.management.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

   Optional<Customer> findByPhone(Long phone);
}
