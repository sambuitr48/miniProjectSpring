package co.cue.edu.miniproject.demo.dtos;

import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.Date;

@Builder
public record ReservationDTO(
        Long idReservation,
        @NotNull(message = "User ID cannot be null")
        @Positive(message = "User ID must be positive")
        User idUser,
        @NotNull(message = "Vehicle ID cannot be null")
        @Positive(message = "Vehicle ID must be positive")
        Vehicle idVehicle,
        Date fecha_inicio,
        Date fecha_fin
) {

}
