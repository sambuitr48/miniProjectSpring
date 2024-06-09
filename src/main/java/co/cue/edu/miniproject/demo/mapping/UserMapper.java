package co.cue.edu.miniproject.demo.mapping;

import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.models.User;

public class UserMapper {
    public static User mapFrom(UserDTO userDTO) {
        return User.builder()
                .user_id(userDTO.user_id())
                .name(userDTO.name())
                .mail(userDTO.mail())
                .mobile(userDTO.mobile())
                .build();
    }

    public static UserDTO mapFrom(User user){
        return UserDTO.builder()
                .user_id(user.getUser_id())
                .name(user.getName())
                .mail(user.getMail())
                .mobile(user.getMobile())
                .build();
    }
}
