package co.cue.edu.miniproject.demo.models;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
@Table(name = "vehicles")
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;
    private String vehicleCategory;
    private String brand;
    private String plate;
    private Double price;
    private String state;
}