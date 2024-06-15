package co.cue.edu.miniproject.demo.dtos;

import co.cue.edu.miniproject.demo.domain.models.Reservation;
import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record PaymentDTO(
        Long idPay,
        Reservation idReservation,
        @NotNull(message = "User ID cannot be null")
        @Positive(message = "User ID must be positive")
        User idUser,
        @NotNull(message = "Vehicle ID cannot be null")
        @Positive(message = "Vehicle ID must be positive")
        Vehicle idVehicle
) {
}
