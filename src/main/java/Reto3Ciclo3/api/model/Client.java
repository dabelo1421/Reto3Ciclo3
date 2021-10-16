package Reto3Ciclo3.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column(length = 45)
    private String name;

    @Column(length = 3)
    private Integer age;

    @OneToMany
    private List<Message> message;

}
