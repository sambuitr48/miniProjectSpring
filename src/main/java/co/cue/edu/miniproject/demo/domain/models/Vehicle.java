package co.cue.edu.miniproject.demo.domain.models;
import co.cue.edu.miniproject.demo.domain.enums.VehicleCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;
    private String brand;
    private String plate;
    private Double price;
    private String state;

    @Enumerated(EnumType.STRING)
    private VehicleCategory category;

    @OneToMany(mappedBy = "vehicles", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("vehicles")
    private List<Reservation> reservations;

}