package co.cue.edu.miniproject.demo.services.impl;

import co.cue.edu.miniproject.demo.domain.mapping.PaymentMapper;
import co.cue.edu.miniproject.demo.domain.models.Payment;
import co.cue.edu.miniproject.demo.dtos.PaymentDTO;
import co.cue.edu.miniproject.demo.jparepositories.PaymentRepositoryJPA;
import co.cue.edu.miniproject.demo.services.PaymentService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the PaymentService interface that provides operations
 * for managing payments.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepositoryJPA paymentRepositoryJPA;

    /**
     * Adds a new payment to the database.
     * @param paymentDTO The DTO containing payment information to be saved.
     */
    @Override
    public void addPayment(PaymentDTO paymentDTO) {
        paymentRepositoryJPA.save(PaymentMapper.mapFromDTO(paymentDTO));
    }

    /**
     * Removes a payment from the database based on its ID.
     * @param idPay The ID of the payment to be removed.
     */
    @Override
    public void removePay(Long idPay) {
        paymentRepositoryJPA.deleteById(idPay);
    }

    /**
     * Retrieves all payments from the database.
     * @return A list of PaymentDTO objects representing all payments in the database.
     */
    @Override
    public List<PaymentDTO> getPay() {
        return paymentRepositoryJPA.findAll().stream()
                .map(PaymentMapper::mapFromModel)
                .toList();
    }

    /**
     * Finds a payment in the database by its ID.
     * @param idPay The ID of the payment to find.
     * @return The Payment object corresponding to the given ID.
     * @throws BadRequestException If no payment with the given ID is found.
     */
    @Override
    public Payment findById(Long idPay) throws BadRequestException {
        return paymentRepositoryJPA.findById(idPay)
                .orElseThrow(() -> new BadRequestException());
    }
}
