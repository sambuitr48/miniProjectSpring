package co.cue.edu.miniproject.demo.domain.mapping;

import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.dtos.UserDTO;

public class UserMapper {
    public static User mapFromDto(UserDTO userDTO) { //MapFromDto
        return User.builder()
                .user_id(userDTO.user_id())
                .name(userDTO.name())
                .mail(userDTO.mail())
                .mobile(userDTO.mobile())
                .build();
    }

    public static UserDTO mapFromModel(User user){ //MapFromModel
        return UserDTO.builder()
                .user_id(user.getUser_id())
                .name(user.getName())
                .mail(user.getMail())
                .mobile(user.getMobile())
                .build();
    }
}
