package invoice.management.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Integer id;

    @Column(name = "state_name")
    private String name;

    @OneToOne(mappedBy = "stateId", cascade = CascadeType.ALL)
    private Customer customer;

}
