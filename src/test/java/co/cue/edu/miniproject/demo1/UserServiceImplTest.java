package co.cue.edu.miniproject.demo1;

import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.jparepositories.UserRepositoryJPA;
import co.cue.edu.miniproject.demo.domain.mapping.UserMapper;
import co.cue.edu.miniproject.demo.services.impl.UserServiceImpl;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepositoryJPA userRepositoryJPA;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser() {
        UserDTO userDTO = new UserDTO(null, "John Doe", "john@example.com", "password", "12345678");

        userService.addUser(userDTO);

        verify(userRepositoryJPA, times(1)).save(any(User.class));
    }

    @Test
    public void testRemoveUser() {
        Long userId = 1L;

        userService.removeUser(userId);

        verify(userRepositoryJPA, times(1)).deleteById(userId);
    }

    @Test
    public void testGetUser() {
        User user1 = new User(1L, "John Doe", "john@example.com", "password", "12345678", null);
        User user2 = new User(2L, "Jane Smith", "jane@example.com", "password", "87654321", null);

        when(userRepositoryJPA.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<UserDTO> userDTOList = userService.getUser();

        assertEquals(2, userDTOList.size());
        assertEquals(user1.getName(), userDTOList.get(0).name());
        assertEquals(user2.getName(), userDTOList.get(1).name());
    }

    @Test
    public void testFindById_UserExists() throws BadRequestException {
        Long userId = 1L;
        User user = new User(userId, "John Doe", "john@example.com", "password", "12345678", null);

        when(userRepositoryJPA.findById(userId)).thenReturn(Optional.of(user));

        User foundUser = userService.findById(userId);

        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getUser_id());
        assertEquals(user.getName(), foundUser.getName());
    }

    @Test
    public void testFindById_UserNotExists() {
        Long userId = 1L;

        when(userRepositoryJPA.findById(userId)).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> userService.findById(userId));
    }

    @Test
    public void testAuthenticate_Successful() {
        String email = "john@example.com";
        String password = "password";
        User user = new User(1L, "John Doe", email, password, "12345678", null);

        when(userRepositoryJPA.findByMail(email)).thenReturn(user);

        boolean result = userService.authenticate(email, password);

        assertTrue(result);
    }

    @Test
    public void testAuthenticate_Failed_WrongPassword() {
        String email = "john@example.com";
        String password = "wrongpassword";
        User user = new User(1L, "John Doe", email, "password", "12345678", null);

        when(userRepositoryJPA.findByMail(email)).thenReturn(user);

        boolean result = userService.authenticate(email, password);

        assertFalse(result);
    }

    @Test
    public void testAuthenticate_Failed_UserNotFound() {
        String email = "nonexistent@example.com";
        String password = "password";

        when(userRepositoryJPA.findByMail(email)).thenReturn(null);

        boolean result = userService.authenticate(email, password);

        assertFalse(result);
    }
}
