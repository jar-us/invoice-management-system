package invoice.management.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;

    @Column(name = "country_name")
    private String name;

    @OneToOne(mappedBy = "countryId", cascade = CascadeType.ALL)
    private Customer customer;

}
