package co.cue.edu.miniproject.demo.services.impl;

import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import co.cue.edu.miniproject.demo.mapping.VehicleMapper;
import co.cue.edu.miniproject.demo.models.Vehicle;
import co.cue.edu.miniproject.demo.repositories.VehicleRepository;
import co.cue.edu.miniproject.demo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleRepositoryImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public void addVheicle(Vehicle vehicle) {
        vehicleRepository.addVheicle(vehicle);
    }

    @Override
    public void remoceVehicle(Long vehicle_id) {
        vehicleRepository.remoceVehicle(vehicle_id);
    }

    @Override
    public List<VehicleDTO> getVehicle() {
        return vehicleRepository.getVehicle().stream().map(VehicleMapper::mapFrom).toList();
    }

    @Override
    public void findById(Long vehicle_id) {
        vehicleRepository.findById(vehicle_id);
    }
}
