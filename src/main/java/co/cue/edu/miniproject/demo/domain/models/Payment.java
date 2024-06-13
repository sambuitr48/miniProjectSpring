package co.cue.edu.miniproject.demo.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
@Table(name = "paymets")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPay;
    private Long idReservation;
    private Long idUser;
    private Long idVehicle;
}
