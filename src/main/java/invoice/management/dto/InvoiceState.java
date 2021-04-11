package invoice.management.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class InvoiceState {

    @Id
    @GeneratedValue
    private Integer id;
    private String state;

}
