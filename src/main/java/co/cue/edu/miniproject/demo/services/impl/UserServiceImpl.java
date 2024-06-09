package co.cue.edu.miniproject.demo.services.impl;

import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.mapping.UserMapper;
import co.cue.edu.miniproject.demo.models.User;
import co.cue.edu.miniproject.demo.repositories.UserRepository;
import co.cue.edu.miniproject.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void removeUser(Long user_id) {
        userRepository.removeUser(user_id);
    }

    @Override
    public List<UserDTO> getUser() {
        return userRepository.getUser().stream().map(UserMapper::mapFrom).toList();
    }

    @Override
    public void findById(Long user_id) {
        userRepository.findById(user_id);
    }
}
