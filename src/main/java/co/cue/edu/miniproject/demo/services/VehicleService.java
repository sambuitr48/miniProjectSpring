package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.dtos.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void addVheicle(VehicleDTO vehicleDTO);
    void remoceVehicle(Long vehicle_id);
    List<VehicleDTO> getVehicle();
    void findById(Long vehicle_id);
}
