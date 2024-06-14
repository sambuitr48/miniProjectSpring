package co.cue.edu.miniproject.demo.controllers;

import co.cue.edu.miniproject.demo.dtos.PaymentDTO;
import co.cue.edu.miniproject.demo.dtos.ReservationDTO;
import co.cue.edu.miniproject.demo.dtos.UserDTO;
import co.cue.edu.miniproject.demo.services.PaymentService;
import co.cue.edu.miniproject.demo.services.ReservationService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping(value = "/add-payment")
    public void addReservation(@RequestBody PaymentDTO paymentDTO){paymentService.addPayment(paymentDTO);}


    @DeleteMapping(value = "/delete-payment/{payment_id}")
    public void removeReservation(@PathVariable Long payid) {
        paymentService.removePay(payid);
    }

    @GetMapping(value = "/get-payment")
    public List<PaymentDTO> getAllReservations() {
        return paymentService.getPay();
    }

    @GetMapping(value = "/get-payment-byid/{payment_id}")
    public void ReservationById(@PathVariable Long payid) throws BadRequestException {
        paymentService.findById(payid);
    }
}
