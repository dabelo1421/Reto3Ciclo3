package Reto3Ciclo3.api.model;

import javax.persistence.*;

@Entity
@Table(name="Boat")
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String brand;

    @Column(length = 4)
    private Integer year;

    @Column(length = 250)
    private String description;

    @ManyToOne
    private Category category;

}
