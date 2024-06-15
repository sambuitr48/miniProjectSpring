package co.cue.edu.miniproject.demo1;

import co.cue.edu.miniproject.demo.domain.models.Reservation;
import co.cue.edu.miniproject.demo.dtos.ReservationDTO;
import co.cue.edu.miniproject.demo.jparepositories.ReservationRepositoryJPA;
import co.cue.edu.miniproject.demo.domain.mapping.ReservationMapper;
import co.cue.edu.miniproject.demo.services.impl.ReservationServiceImpl;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ReservationServiceImplTest {

    @Mock
    private ReservationRepositoryJPA reservationRepositoryJPA;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddReservation() {
        ReservationDTO reservationDTO = new ReservationDTO(null, null, null, null, null);

        reservationService.addReservation(reservationDTO);

        verify(reservationRepositoryJPA, times(1)).save(any(Reservation.class));
    }

    @Test
    public void testRemoveReservation() {
        Long reservationId = 1L;

        reservationService.removeReservation(reservationId);

        verify(reservationRepositoryJPA, times(1)).deleteById(reservationId);
    }

    @Test
    public void testGetReservation() {
        Reservation reservation1 = new Reservation(1L, null, null, null, null);
        Reservation reservation2 = new Reservation(2L, null, null, null, null);

        when(reservationRepositoryJPA.findAll()).thenReturn(Arrays.asList(reservation1, reservation2));

        List<ReservationDTO> reservationDTOList = reservationService.getReservation();

        assertEquals(2, reservationDTOList.size());
        assertEquals(reservation1.getIdReservation(), reservationDTOList.get(0).idReservation());
        assertEquals(reservation2.getIdReservation(), reservationDTOList.get(1).idReservation());
    }

    @Test
    public void testFindById_ReservationExists() throws BadRequestException {
        Long reservationId = 1L;
        Reservation reservation = new Reservation(reservationId, null, null, null, null);

        when(reservationRepositoryJPA.findById(reservationId)).thenReturn(Optional.of(reservation));

        Reservation foundReservation = reservationService.findById(reservationId);

        assertNotNull(foundReservation);
        assertEquals(reservationId, foundReservation.getIdReservation());
    }

    @Test
    public void testFindById_ReservationNotExists() {
        Long reservationId = 1L;

        when(reservationRepositoryJPA.findById(reservationId)).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> reservationService.findById(reservationId));
    }
}
