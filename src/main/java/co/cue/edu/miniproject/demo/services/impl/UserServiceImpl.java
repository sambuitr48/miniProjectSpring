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

/**
 * Implementation of the UserService interface that provides operations
 * for managing users and authentication.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    /**
     * Adds a new user to the database.
     * @param userDTO The DTO containing user information to be saved.
     */
    @Override
    public void addUser(UserDTO userDTO) {
        userRepositoryJPA.save(UserMapper.mapFromDto(userDTO));
    }

    /**
     * Removes a user from the database based on their ID.
     * @param user_id The ID of the user to be removed.
     */
    @Override
    public void removeUser(Long user_id) {
        userRepositoryJPA.deleteById(user_id);
    }

    /**
     * Retrieves all users from the database.
     * @return A list of UserDTO objects representing all users in the database.
     */
    @Override
    public List<UserDTO> getUser() {
        return userRepositoryJPA.findAll().stream()
                .map(UserMapper::mapFromModel)
                .toList();
    }

    /**
     * Finds a user in the database by their ID.
     * @param user_id The ID of the user to find.
     * @return The User object corresponding to the given ID.
     * @throws BadRequestException If no user with the given ID is found.
     */
    @Override
    public User findById(Long user_id) throws BadRequestException {
        return userRepositoryJPA.findById(user_id)
                .orElseThrow(() -> new BadRequestException());
    }

    /**
     * Authenticates a user based on their email and password.
     * @param email The email of the user.
     * @param password The password of the user.
     * @return true if authentication is successful, false otherwise.
     */
    @Override
    public boolean authenticate(String email, String password) {
        User user = userRepositoryJPA.findByMail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }
}
