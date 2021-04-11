package invoice.management.repo;

import invoice.management.dto.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Integer> {

    State save(State state);
}
