package co.cue.edu.miniproject.demo.domain.mapping;

import co.cue.edu.miniproject.demo.domain.models.Payment;
import co.cue.edu.miniproject.demo.dtos.PaymentDTO;

public class PaymentMapper {
    public static Payment mapFromDTO(PaymentDTO paymentDTO){
        return Payment.builder()
                .idPay(paymentDTO.idPay())
                .idReservation(paymentDTO.idReservation())
                .idUser(paymentDTO.idUser())
                .idVehicle(paymentDTO.idVehicle())
                .build();
    }
    public static PaymentDTO mapFromModel(Payment payment){
        return PaymentDTO.builder()
                .idPay(payment.getIdPay())
                .idReservation(payment.getIdReservation())
                .idUser(payment.getIdUser())
                .idVehicle(payment.getIdVehicle())
                .build();
    }
}
