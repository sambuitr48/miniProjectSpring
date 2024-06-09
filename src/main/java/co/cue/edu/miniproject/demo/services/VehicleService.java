package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import co.cue.edu.miniproject.demo.models.Vehicle;

import java.util.List;

public interface VehicleService {
    void addVheicle(Vehicle vehicle);
    void remoceVehicle(Long vehicle_id);
    List<VehicleDTO> getVehicle();
    void findById(Long vehicle_id);
}
