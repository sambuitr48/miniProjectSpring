package co.cue.edu.miniproject.demo.repositories.impl;

import co.cue.edu.miniproject.demo.models.User;
import co.cue.edu.miniproject.demo.models.Vehicle;
import co.cue.edu.miniproject.demo.repositories.VehicleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class VehicleRepositoryImpl implements VehicleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVheicle(Vehicle vehicle) {
        entityManager.merge(vehicle);
    }

    @Override
    public void remoceVehicle(Long vehicle_id) {
        Vehicle vehicle = entityManager.find(Vehicle.class, vehicle_id);
        entityManager.remove(vehicle);
    }

    @Override
    public List<Vehicle> getVehicle() {
        String query = "FROM Vehicle";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void findById(Long vehicle_id) {
        Vehicle vehicle = entityManager.find(Vehicle.class, vehicle_id);
        if (vehicle == null) {
            throw new EntityNotFoundException("No se encontró el vehiculo con el ID: " + vehicle_id);
        }
    }
}
