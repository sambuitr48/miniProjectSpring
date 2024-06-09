package co.cue.edu.miniproject.demo.mapping;

import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import co.cue.edu.miniproject.demo.models.Vehicle;
import lombok.Builder;

@Builder
public class VehicleMapper {
    public static Vehicle mapFrom(VehicleDTO vehicleDTO){
        return Vehicle.builder()
                .vehicle_id(vehicleDTO.vehicle_id())
                .vehicleCategory(vehicleDTO.vehicleCategory())
                .brand(vehicleDTO.brand())
                .plate(vehicleDTO.plate())
                .price(vehicleDTO.price())
                .state(vehicleDTO.state())
                .build();
    }

    public static VehicleDTO mapFrom(Vehicle vehicle){
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
