package co.cue.edu.miniproject.demo.jparepositories;

import co.cue.edu.miniproject.demo.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<User, Long> {
    User findByMail(String mail);
}