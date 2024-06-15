package co.cue.edu.miniproject.demo.services.impl;

import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.domain.mapping.UserMapper;
import co.cue.edu.miniproject.demo.jparepositories.UserRepositoryJPA;
import co.cue.edu.miniproject.demo.services.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Override
    public void addUser(UserDTO userDTO) {
        userRepositoryJPA.save(UserMapper.mapFromDto(userDTO));
    }

    @Override
    public void removeUser(Long user_id) {
        userRepositoryJPA.deleteById(user_id);
    }

    @Override
    public List<UserDTO> getUser() {
        return userRepositoryJPA.findAll().stream().map(UserMapper::mapFromModel).toList();
    }

    @Override
    public User findById(Long user_id) throws BadRequestException {
        return userRepositoryJPA.findById(user_id).orElseThrow(()-> new BadRequestException());}

    @Override
    public boolean authenticate(String email, String password) {
        User user = userRepositoryJPA.findByMail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }
}
