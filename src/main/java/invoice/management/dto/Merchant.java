package invoice.management.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

//@Data
@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    private Long id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "merchant")
    private Collection<Invoice> invoices;

}
