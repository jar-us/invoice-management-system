package invoice.management.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Invoice {

    private Integer id;
    private String invoicedNumber;
    private String invoicedDate;
    private LocalTime invoicedTime;
    private LocalDate dueDate;
    private Boolean enableAutoAlert;
    private Integer totalAmount;

}
