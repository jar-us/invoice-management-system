package invoice.management.repo;

import invoice.management.dto.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Rollback(value = false)
class ItemRepositoryTest {

   @Autowired
   private ItemRepository repository;


   @Test
   public void test_save_Item(){
      Item item = new Item();
      item.setName("Running Shoes");
      item.setDescription("This shoe is good for running and walking.");
      item.setPrice(111.11f);

      Item savedItem = repository.save(item);

      assertThat(savedItem.getId()).isEqualTo(1);

   }
}