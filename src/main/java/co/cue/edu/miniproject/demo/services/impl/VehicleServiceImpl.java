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

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepositoryJPA vehicleRepositoryJPA;

    @Override
    public void addVheicle(VehicleDTO vehicleDTO) {
        vehicleRepositoryJPA.save(VehicleMapper.mapFromDto(vehicleDTO));
    }

    @Override
    public void remoceVehicle(Long vehicle_id) {
        vehicleRepositoryJPA.deleteById(vehicle_id);
    }

    @Override
    public List<VehicleDTO> getVehicle() {
        return vehicleRepositoryJPA.findAll().stream().map(VehicleMapper::mapFromModel).toList();
    }

    @Override
    public Vehicle findById(Long vehicle_id) throws BadRequestException {
    return vehicleRepositoryJPA.findById(vehicle_id).orElseThrow(()->new BadRequestException());
    }
}
