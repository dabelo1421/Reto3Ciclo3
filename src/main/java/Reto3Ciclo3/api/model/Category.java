package Reto3Ciclo3.api.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(length = 250)
    private String description;

    @OneToMany
    private List<Boat> boat;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Boat> getBoat() {
        return boat;
    }

    public void setBoat(List<Boat> boat) {
        this.boat = boat;
    }
}
