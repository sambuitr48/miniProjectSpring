package co.cue.edu.miniproject.demo.domain.mapping;

import co.cue.edu.miniproject.demo.domain.models.Payment;
import co.cue.edu.miniproject.demo.domain.models.Reservation;
import co.cue.edu.miniproject.demo.dtos.PaymentDTO;
import co.cue.edu.miniproject.demo.dtos.ReservationDTO;

public class ReservationMapper {
    public static Reservation mapFromDTO(ReservationDTO reservationDTO){
        return Reservation.builder()
                .idReservation(reservationDTO.idReservation())
                .user(reservationDTO.idUser())
                .fecha_fin(reservationDTO.fecha_fin())
                .fecha_inicio(reservationDTO.fecha_inicio())
                .vehicle(reservationDTO.idVehicle())
                .build();

    }
    public static ReservationDTO mapFromModel(Reservation reservation){
        return ReservationDTO.builder()
                .idReservation(reservation.getIdReservation())
                .idUser(reservation.getUser())
                .fecha_inicio(reservation.getFecha_inicio())
                .fecha_fin(reservation.getFecha_fin())
                .idVehicle(reservation.getVehicle())
                .build();
    }
}
