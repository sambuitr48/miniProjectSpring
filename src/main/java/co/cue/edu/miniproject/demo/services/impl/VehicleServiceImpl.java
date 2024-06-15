package co.cue.edu.miniproject.demo.services.impl;

import co.cue.edu.miniproject.demo.domain.mapping.VehicleMapper;
import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import co.cue.edu.miniproject.demo.dtos.VehicleDTO;
import co.cue.edu.miniproject.demo.jparepositories.VehicleRepositoryJPA;
import co.cue.edu.miniproject.demo.services.VehicleService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepositoryJPA vehicleRepositoryJPA;

    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        vehicleRepositoryJPA.save(VehicleMapper.mapFromDto(vehicleDTO));
    }

    @Override
    public void removeVehicle(Long vehicle_id) {
        vehicleRepositoryJPA.deleteById(vehicle_id);
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        return vehicleRepositoryJPA.findAll().stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle findById(Long vehicle_id) throws BadRequestException {
        return vehicleRepositoryJPA.findById(vehicle_id)
                .orElseThrow(() -> new BadRequestException());
    }

    @Override
    public List<VehicleDTO> findByState(String state) {
        return vehicleRepositoryJPA.findByState(state).stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> findByPrice(Double price) {
        return vehicleRepositoryJPA.findByPrice(price).stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> findByCategory(String category) {
        return vehicleRepositoryJPA.findByCategory(category).stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }
}
