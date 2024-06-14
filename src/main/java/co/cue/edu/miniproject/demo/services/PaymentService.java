package co.cue.edu.miniproject.demo.services;

import co.cue.edu.miniproject.demo.domain.models.Payment;
import co.cue.edu.miniproject.demo.dtos.PaymentDTO;
import co.cue.edu.miniproject.demo.dtos.UserDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface PaymentService {
    void addPayment(PaymentDTO paymentDTO);
    void removePay(Long idPay);
    List<PaymentDTO> getPay();
    Payment findById(Long idPay) throws BadRequestException;
}
