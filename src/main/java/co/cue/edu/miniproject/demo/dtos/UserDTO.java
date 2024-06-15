package co.cue.edu.miniproject.demo.dtos;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record UserDTO(
        Long user_id,
        @NotNull(message = "Name cannot be null")
        @NotBlank(message = "Name cannot be blank")
        @NotEmpty(message = "Name cannot be empty")
        String name,
        @Email(message = "Invalid email format")
        String mail,
        @Size(min = 4, max = 8, message = "Password must be between 4 and 8 characters")
        String password,
        @Positive(message = "Mobile number must be positive")
        @Size(min = 8, max = 10, message = "Mobile number must be between 8 and 10 characters")
        String mobile
) {
}
