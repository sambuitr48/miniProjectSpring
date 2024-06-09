package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.models.User;
import co.cue.edu.miniproject.demo.models.Vehicle;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(Long user_id);
    List<UserDTO> getUser();
    void findById(Long user_id);
}
