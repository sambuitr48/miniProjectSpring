package co.cue.edu.miniproject.demo.domain.mapping;

import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import lombok.Builder;

@Builder
public class VehicleMapper {
    public static Vehicle mapFromDto(VehicleDTO vehicleDTO){ //MapFromDTO
        return Vehicle.builder()
                .vehicle_id(vehicleDTO.vehicle_id())
                .vehicleCategory(vehicleDTO.vehicleCategory())
                .brand(vehicleDTO.brand())
                .plate(vehicleDTO.plate())
                .price(vehicleDTO.price())
                .state(vehicleDTO.state())
                .build();
    }

    public static VehicleDTO mapFromModel(Vehicle vehicle){ //MapFromModel
        return VehicleDTO.builder()
                .vehicle_id(vehicle.getVehicle_id())
                .vehicleCategory(vehicle.getVehicleCategory())
                .brand(vehicle.getBrand())
                .plate(vehicle.getPlate())
                .price(vehicle.getPrice())
                .state(vehicle.getState())
                .build();
    }
}
