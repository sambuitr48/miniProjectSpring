package co.cue.edu.miniproject.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record VehicleDTO(
        Long vehicle_id,
        String category,
        @NotNull(message = "Brand cannot be null")
        @NotBlank(message = "Brand cannot be blank")
        String brand,
        @NotBlank(message = "Plate cannot be blank")
        String plate,
        @Positive(message = "Price must be positive")
        @NotNull(message = "Price cannot be null")
        Double price,
        String state ) {
}
