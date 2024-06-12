package co.cue.edu.miniproject.demo.controllers;

import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/add-user")
    public void addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }

    @DeleteMapping(value = "/delete-user/{user_id}")
    public void removeUser(@PathVariable Long user_id) {
        userService.removeUser(user_id);
    }

    @GetMapping(value = "/get-users")
    public List<UserDTO> getAllUsers() {
      return userService.getUser();
    }

    @GetMapping(value = "/get-user-byid/{user_id}")
    public void userById(@PathVariable Long user_id){
        userService.findById(user_id);
    }
}
