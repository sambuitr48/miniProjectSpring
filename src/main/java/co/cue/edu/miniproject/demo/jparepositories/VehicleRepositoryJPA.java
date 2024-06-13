package co.cue.edu.miniproject.demo.jparepositories;

import co.cue.edu.miniproject.demo.domain.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepositoryJPA extends JpaRepository<Vehicle, Long> {
}
