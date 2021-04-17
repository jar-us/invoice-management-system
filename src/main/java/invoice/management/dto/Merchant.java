package invoice.management.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    private Long id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "merchant")
    private Collection<Invoice> invoices;

}
