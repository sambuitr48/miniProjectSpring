package co.cue.edu.miniproject.demo.controllers;

import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        // Assuming UserDTO contains fields like email and password
        String email = userDTO.mail();
        String password = userDTO.password();

        // Perform authentication logic (not shown here, typically involves checking credentials)
        boolean isAuthenticated = userService.authenticate(email, password);

        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Login failed. Invalid credentials.";
        }
    }
}
