package co.cue.edu.miniproject.demo.dtos;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record UserDTO(
                      Long user_id,
                      @NotNull
                      @NotBlank
                      @NotEmpty
                      String name,
                      @Email(message = "invalid email")
                      String mail,
                      @Size(min = 4, max = 8)
                      String password,
                       @Positive
                       @Size(min = 8, max = 10)
                      String mobile
                ) {
}
