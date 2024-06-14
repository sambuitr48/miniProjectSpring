package co.cue.edu.miniproject.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
@Builder
public record VehicleDTO(
                         Long vehicle_id,
                         String category,
                         @NotNull
                         @NotBlank
                         String brand,
                         @NotBlank
                         String plate,
                         @Positive
                         @NotNull
                         Double price,
                         String state ) {
}
