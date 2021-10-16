package Reto3Ciclo3.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @Column
    private Date startDate;

    @Column
    private Date devolutionDate;

    @Column
    private Date createDay;

}
