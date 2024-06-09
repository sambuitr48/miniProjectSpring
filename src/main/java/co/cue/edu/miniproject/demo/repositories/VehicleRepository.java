package co.cue.edu.miniproject.demo.repositories;

import co.cue.edu.miniproject.demo.models.User;
import co.cue.edu.miniproject.demo.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    void addVheicle(Vehicle vehicle);
    void remoceVehicle(Long vehicle_id);
    List<Vehicle> getVehicle();

    void findById(Long vehicle_id);
}
