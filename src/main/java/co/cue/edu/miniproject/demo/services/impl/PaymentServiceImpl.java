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
    @Service
    public class    PaymentServiceImpl implements PaymentService {
        @Autowired
        private PaymentRepositoryJPA payRep;
        @Override
        public void addPayment(PaymentDTO paymentDTO) {
            payRep.save(PaymentMapper.mapFromDTO(paymentDTO));
        }

        @Override
        public void removePay(Long idPay) {
        payRep.deleteById(idPay);
        }

        @Override
        public List<PaymentDTO> getPay() {
            return payRep.findAll().stream().map(PaymentMapper::mapFromModel).toList();
        }

        @Override
        public Payment findById(Long idPay) throws BadRequestException {
        return payRep.findById(idPay).orElseThrow(()-> new BadRequestException());
        }
    }
