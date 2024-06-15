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

/**
 * Implementation of the VehicleService interface that provides CRUD operations
 * for managing vehicles and additional search functionalities.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepositoryJPA vehicleRepositoryJPA;

    /**
     * Saves a new vehicle into the database.
     * @param vehicleDTO The DTO containing vehicle information to be saved.
     */
    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        vehicleRepositoryJPA.save(VehicleMapper.mapFromDto(vehicleDTO));
    }

    /**
     * Removes a vehicle from the database based on its ID.
     * @param vehicle_id The ID of the vehicle to be removed.
     */
    @Override
    public void removeVehicle(Long vehicle_id) {
        vehicleRepositoryJPA.deleteById(vehicle_id);
    }

    /**
     * Retrieves all vehicles from the database.
     * @return A list of VehicleDTO objects representing all vehicles in the database.
     */
    @Override
    public List<VehicleDTO> getVehicles() {
        return vehicleRepositoryJPA.findAll().stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    /**
     * Finds a vehicle in the database by its ID.
     * @param vehicle_id The ID of the vehicle to find.
     * @return The Vehicle object corresponding to the given ID.
     * @throws BadRequestException If no vehicle with the given ID is found.
     */
    @Override
    public Vehicle findById(Long vehicle_id) throws BadRequestException {
        return vehicleRepositoryJPA.findById(vehicle_id)
                .orElseThrow(() -> new BadRequestException());
    }

    /**
     * Retrieves vehicles from the database that match the given state.
     * @param state The state of the vehicles to search for.
     * @return A list of VehicleDTO objects representing vehicles with the specified state.
     */
    @Override
    public List<VehicleDTO> findByState(String state) {
        return vehicleRepositoryJPA.findByState(state).stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves vehicles from the database that match the given price.
     * @param price The price of the vehicles to search for.
     * @return A list of VehicleDTO objects representing vehicles with the specified price.
     */
    @Override
    public List<VehicleDTO> findByPrice(Double price) {
        return vehicleRepositoryJPA.findByPrice(price).stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves vehicles from the database that match the given category.
     * @param category The category of the vehicles to search for.
     * @return A list of VehicleDTO objects representing vehicles with the specified category.
     */
    @Override
    public List<VehicleDTO> findByCategory(String category) {
        return vehicleRepositoryJPA.findByCategory(category).stream()
                .map(VehicleMapper::mapFromModel)
                .collect(Collectors.toList());
    }
}
