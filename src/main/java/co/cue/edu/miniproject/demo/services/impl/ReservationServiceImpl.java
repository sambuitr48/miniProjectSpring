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

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepositoryJPA reservationRepositoryJPA;

    @Override
    public void addReservation(ReservationDTO reservationDTO) {
    reservationRepositoryJPA.save(ReservationMapper.mapFromDTO(reservationDTO));
    }

    @Override
    public void removeReservation(Long idReservation) {
    reservationRepositoryJPA.deleteById(idReservation);
    }

    @Override
    public List<ReservationDTO> getReservation() {
        return reservationRepositoryJPA.findAll().stream().map(ReservationMapper::mapFromModel).toList(); //el mismo error de ahorita
    }

    @Override
    public Reservation findById(Long idReservation) throws BadRequestException {
    return reservationRepositoryJPA.findById(idReservation).orElseThrow(()-> new BadRequestException());
    }
}
