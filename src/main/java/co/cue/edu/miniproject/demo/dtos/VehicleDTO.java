package co.cue.edu.miniproject.demo.dtos;

import lombok.Builder;
@Builder
public record VehicleDTO(
                         Long vehicle_id,
                         String vehicleCategory,
                         String brand,
                         String plate,
                         Double price,
                         String state ) {
}
