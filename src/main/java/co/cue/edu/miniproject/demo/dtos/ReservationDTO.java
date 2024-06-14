package co.cue.edu.miniproject.demo.dtos;

import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.Date;
@Builder
public record ReservationDTO (Long idReservation,
                              @NotNull
                              @Positive
                              User idUser,
                              @NotNull
                              @Positive
                              Vehicle idVehicle,
                              Date fecha_inicio,
                              Date fecha_fin
                              ) {

}
