package co.cue.edu.miniproject.demo.controllers;

import co.cue.edu.miniproject.demo.dtos.ReservationDTO;
import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.services.ReservationService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
@Autowired
    private ReservationService reservationService;
    @PostMapping(value = "/add-reservation")
    public void addReservation(@RequestBody ReservationDTO reservationDTO){reservationService.addReservation(reservationDTO);

    }
    @DeleteMapping(value = "/delete-reservation/{reservation_id}")
    public void removeReservation(@PathVariable Long reservationid) {
        reservationService.removeReservation(reservationid);
    }

    @GetMapping(value = "/get-reservation")
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getReservation();
    }

    @GetMapping(value = "/get-reservation-byid/{reservation_id}")
    public void ReservationById(@PathVariable Long reservationId) throws BadRequestException {
        reservationService.findById(reservationId);
    }
}
