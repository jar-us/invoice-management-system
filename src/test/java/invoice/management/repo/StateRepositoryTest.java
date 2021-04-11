package invoice.management.repo;


import invoice.management.dto.City;
import invoice.management.dto.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StateRepositoryTest {

    @Autowired
    private StateRepository repository;

    @Test
    public void test_save_state() {
        State state = new State();
        state.setName("KA");
        State savedState = repository.save(state);

        assertThat(savedState.getId()).isEqualTo(1);
    }
}
