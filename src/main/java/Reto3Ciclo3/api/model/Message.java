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
    @JoinColumn(name = "idBoat")
    private Boat boat;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;


    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
