package invoice.management.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Tax {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Float percent;
}
