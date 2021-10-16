package Reto3Ciclo3.api.model;

import javax.persistence.*;

@Entity
@Table(name="Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(length = 250)
    private String message;

    @ManyToOne
    private Client client;
}
