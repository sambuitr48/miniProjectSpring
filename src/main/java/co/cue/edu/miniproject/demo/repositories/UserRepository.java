package co.cue.edu.miniproject.demo.repositories;

import co.cue.edu.miniproject.demo.models.User;
import co.cue.edu.miniproject.demo.models.Vehicle;

import java.util.List;

public interface UserRepository {

    void addUser(User user);
    void removeUser(Long user_id);
    List<User> getUser();

    void findById(Long user_id);
}
