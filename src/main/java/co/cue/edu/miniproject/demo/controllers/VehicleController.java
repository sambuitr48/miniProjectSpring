package co.cue.edu.miniproject.demo.controllers;

import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import co.cue.edu.miniproject.demo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/add-user")
    public void addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.addVheicle(vehicleDTO);
    }

    @DeleteMapping(value = "/delete-user/{user_id}")
    public void removeVehicle(@PathVariable Long vehicle_id) {
        vehicleService.remoceVehicle(vehicle_id);
    }

    @GetMapping(value = "/get-users")
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getVehicle();
    }

    @GetMapping(value = "/get-user-byid/{user_id}")
    public void VehicleById(@PathVariable Long vehicle_id){
        vehicleService.findById(vehicle_id);
    }
}
