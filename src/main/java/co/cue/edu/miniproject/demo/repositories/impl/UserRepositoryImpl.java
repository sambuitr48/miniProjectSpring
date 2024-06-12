package co.cue.edu.miniproject.demo.repositories.impl;

import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.domain.models.User;
import co.cue.edu.miniproject.demo.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(UserDTO user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long user_id) {
        User user = entityManager.find(User.class, user_id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getUser() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void findById(Long user_id) {
        User user = entityManager.find(User.class, user_id);
        if (user == null) {
            throw new EntityNotFoundException("No se encontró el usuario con el ID: " + user_id);
        }
    }
}
