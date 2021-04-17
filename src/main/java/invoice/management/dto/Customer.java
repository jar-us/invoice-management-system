package invoice.management.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customer_id;

    @Column
    private String name;

    @OneToMany(mappedBy = "customer")
    private Collection<Invoice> invoices;
}
