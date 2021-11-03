package Reto3Ciclo3.api.services;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.model.Reservation;
import Reto3Ciclo3.api.reportes.ContadorClientes;
import Reto3Ciclo3.api.reportes.StatusReservas;
import Reto3Ciclo3.api.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> baux=reservationRepository.getReservation(reservation.getIdReservation());
            if (baux.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() !=null){
            Optional<Reservation> auxUpdt=reservationRepository.getReservation(reservation.getIdReservation());
            if(!auxUpdt.isEmpty()){
                if (reservation.getStartDate()!=null){
                    auxUpdt.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    auxUpdt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!=null){
                    auxUpdt.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(auxUpdt.get());
                return auxUpdt.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId){
        Boolean aBoolean = getReservation(reservationId).map(boat -> {
            reservationRepository.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservas getReporteStatusReservaciones(){
        List<Reservation>completed= reservationRepository.ReservacionStatus("completed");
        List<Reservation>cancelled= reservationRepository.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());

    }

    public List<Reservation> getReportesTiempoReservaciones(String datoA, String datoB){

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservacionTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }

    public List<ContadorClientes> servicioTopClientes(){
        return reservationRepository.getTopClientes();
    }

}
