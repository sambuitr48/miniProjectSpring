package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.dtos.UserDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface UserService{
    void addUser(UserDTO userDTO);
    void removeUser(Long user_id);
    List<UserDTO> getUser();
    User findById(Long user_id) throws BadRequestException;
    boolean authenticate(String email, String password);
}
