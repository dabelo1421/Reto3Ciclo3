package Reto3Ciclo3.api.repository;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.repository.Crud.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoatRepository {

    @Autowired
    BoatCrudRepository boatCrudRepository;

    public List<Boat> obtenerBoat(){

        return (List<Boat>) boatCrudRepository.findAll();
    }

}
