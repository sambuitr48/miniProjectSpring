package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import org.apache.coyote.BadRequestException;
import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleDTO vehicleDTO);
    void removeVehicle(Long vehicle_id);
    List<VehicleDTO> getVehicles();
    Vehicle findById(Long vehicle_id) throws BadRequestException;
    List<VehicleDTO> findByState(String state);
    List<VehicleDTO> findByPrice(Double price);
    List<VehicleDTO> findByCategory(String category);
}
