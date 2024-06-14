package co.cue.edu.miniproject.demo.jparepositories;

import co.cue.edu.miniproject.demo.domain.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoryJPA extends JpaRepository<Payment,Long> {
}
