    package co.cue.edu.miniproject.demo.services.impl;

    import co.cue.edu.miniproject.demo.dtos.UserDTO;
    import co.cue.edu.miniproject.demo.domain.mapping.UserMapper;
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
        public void addUser(UserDTO userDTO) {
            userRepository.addUser(userDTO);
        } //Cambiar a DTO

        @Override
        public void removeUser(Long user_id) {
            userRepository.removeUser(user_id);
        }

        @Override
        public List<UserDTO> getUser() {
            return userRepository.getUser().stream().map(UserMapper::mapFromModel).toList();
        }

        @Override
        public void findById(Long user_id) {
            userRepository.findById(user_id);
        }
    }
