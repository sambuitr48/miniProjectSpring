package co.cue.edu.miniproject.demo.jparepositories;

import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepositoryJPA extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByState(String state);
    List<Vehicle> findByPrice(Double price);
    List<Vehicle> findByCategory(String category);
}