package Reto3Ciclo3.api.web;



import Reto3Ciclo3.api.model.Reservation;
import Reto3Ciclo3.api.reportes.ContadorClientes;
import Reto3Ciclo3.api.reportes.StatusReservas;
import Reto3Ciclo3.api.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable ("id") int reservationId){
        return reservationService.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return reservationService.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return reservationService.getReporteStatusReservaciones();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo(@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){

        return reservationService.getReportesTiempoReservaciones(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return reservationService.servicioTopClientes();
    }

}
