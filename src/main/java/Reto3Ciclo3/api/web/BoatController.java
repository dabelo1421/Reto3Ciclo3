package Reto3Ciclo3.api.web;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.services.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/Boat")

public class BoatController {

    @Autowired
    BoatService boatService;

    @GetMapping("/all")
    public List<Boat> getBoat(){
        return boatService.obtenerBoat();
    }
}
