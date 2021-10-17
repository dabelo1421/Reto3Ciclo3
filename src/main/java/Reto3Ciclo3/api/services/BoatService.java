package Reto3Ciclo3.api.services;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatService {

    @Autowired
    BoatRepository boatRepository;

    public List<Boat> obtenerBoat(){

        return boatRepository.obtenerBoat();
    }
}
