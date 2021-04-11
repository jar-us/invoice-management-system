package invoice.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "street")
    private String street;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City cityId;


    @OneToOne
    @JoinColumn(name = "state_id")
    private State stateId;


    @OneToOne
    @JoinColumn(name = "country_id")
    private Country countryId;


}
