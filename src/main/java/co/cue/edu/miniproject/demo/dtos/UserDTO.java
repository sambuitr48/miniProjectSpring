package co.cue.edu.miniproject.demo.dtos;

import lombok.Builder;

@Builder
public record UserDTO(
                      Long user_id,
                      String name,
                      String mail,
                      String password,
                      String mobile
                ) {
}
