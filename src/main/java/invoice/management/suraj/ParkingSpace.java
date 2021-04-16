package invoice.management.suraj;

import javax.persistence.*;

@Entity
@Table(name = "parking_space")
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


//    @OneToOne(mappedBy = "parkingSpace")
    @OneToOne
    private Employee employee;

}
