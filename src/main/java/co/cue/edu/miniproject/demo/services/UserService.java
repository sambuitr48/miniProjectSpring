package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.dtos.UserDTO;

import java.util.List;

public interface UserService{
    void addUser(UserDTO userDTO);
    void removeUser(Long user_id);
    List<UserDTO> getUser();
    void findById(Long user_id);
}
