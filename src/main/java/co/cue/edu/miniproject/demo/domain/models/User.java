package co.cue.edu.miniproject.demo.domain.models;

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
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String name;
    private String mail;
    private String password;
    private String mobile;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("users")
    private List<Reservation> reservations;
}
