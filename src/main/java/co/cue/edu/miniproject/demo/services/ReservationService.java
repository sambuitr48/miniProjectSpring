package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.domain.models.Reservation;
import co.cue.edu.miniproject.demo.dtos.PaymentDTO;
import co.cue.edu.miniproject.demo.dtos.ReservationDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ReservationService {
    void addReservation(ReservationDTO reservationDTO);
    void removeReservation(Long idReservation);
    List<ReservationDTO> getReservation();
    Reservation findById(Long idReservation) throws BadRequestException;
}
