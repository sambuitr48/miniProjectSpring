package co.cue.edu.miniproject.demo.services.impl;

import co.cue.edu.miniproject.demo.domain.mapping.ReservationMapper;
import co.cue.edu.miniproject.demo.domain.models.Reservation;
import co.cue.edu.miniproject.demo.dtos.ReservationDTO;
import co.cue.edu.miniproject.demo.jparepositories.ReservationRepositoryJPA;
import co.cue.edu.miniproject.demo.services.ReservationService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the ReservationService interface that provides operations
 * for managing reservations.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepositoryJPA reservationRepositoryJPA;

    /**
     * Adds a new reservation to the database.
     * @param reservationDTO The DTO containing reservation information to be saved.
     */
    @Override
    public void addReservation(ReservationDTO reservationDTO) {
        reservationRepositoryJPA.save(ReservationMapper.mapFromDTO(reservationDTO));
    }

    /**
     * Removes a reservation from the database based on its ID.
     * @param idReservation The ID of the reservation to be removed.
     */
    @Override
    public void removeReservation(Long idReservation) {
        reservationRepositoryJPA.deleteById(idReservation);
    }

    /**
     * Retrieves all reservations from the database.
     * @return A list of ReservationDTO objects representing all reservations in the database.
     */
    @Override
    public List<ReservationDTO> getReservation() {
        return reservationRepositoryJPA.findAll().stream()
                .map(ReservationMapper::mapFromModel)
                .toList();
    }

    /**
     * Finds a reservation in the database by its ID.
     * @param idReservation The ID of the reservation to find.
     * @return The Reservation object corresponding to the given ID.
     * @throws BadRequestException If no reservation with the given ID is found.
     */
    @Override
    public Reservation findById(Long idReservation) throws BadRequestException {
        return reservationRepositoryJPA.findById(idReservation)
                .orElseThrow(() -> new BadRequestException());
    }
}
