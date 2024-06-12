package co.cue.edu.miniproject.demo.repositories;

import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.domain.models.User;

import java.util.List;

public interface UserRepository {

    void addUser(UserDTO userDTO);
    void removeUser(Long user_id);
    List<User> getUser();

    void findById(Long user_id);
}
