package invoice.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "city_name")
    private String name;

    @OneToOne(mappedBy = "cityId", cascade = CascadeType.ALL)
    private Customer customer;

}
