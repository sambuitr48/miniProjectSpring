package co.cue.edu.miniproject.demo.controllers;

import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import co.cue.edu.miniproject.demo.services.VehicleService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/add-vehicle")
    public void addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.addVehicle(vehicleDTO);
    }

    @DeleteMapping(value = "/delete-vehicle/{vehicle_id}")
    public void removeVehicle(@PathVariable Long vehicle_id) {
        vehicleService.removeVehicle(vehicle_id);
    }

    @GetMapping(value = "/get-vehicles")
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping(value = "/get-vehicle-byid/{vehicle_id}")
    public void VehicleById(@PathVariable Long vehicle_id) throws BadRequestException {
        vehicleService.findById(vehicle_id);
    }
    @GetMapping(value = "/get-vehicles-by-state/{state}")
    public List<VehicleDTO> getVehiclesByState(@PathVariable String state) {
        return vehicleService.findByState(state);
    }

    @GetMapping(value = "/get-vehicles-by-category/{category}")
    public List<VehicleDTO> getVehiclesByCategory(@PathVariable String category) {
        return vehicleService.findByCategory(category);
    }

    @GetMapping(value = "/get-vehicles-by-price/{price}")
    public List<VehicleDTO> getVehiclesByPrice(@PathVariable Double price) {
        return vehicleService.findByPrice(price);
    }
}
