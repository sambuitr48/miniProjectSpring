package co.cue.edu.miniproject.demo.repositories;

import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import co.cue.edu.miniproject.demo.domain.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    void addVheicle(VehicleDTO vehicle);
    void remoceVehicle(Long vehicle_id);
    List<Vehicle> getVehicle();

    void findById(Long vehicle_id);
}
