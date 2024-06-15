package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface VehicleService {
    void addVheicle(VehicleDTO vehicleDTO);
    void remoceVehicle(Long vehicle_id);
    List<VehicleDTO> getVehicle();
    Vehicle findById(Long vehicle_id) throws BadRequestException;
}
