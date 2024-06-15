package co.cue.edu.miniproject.demo1;

import co.cue.edu.miniproject.demo.domain.models.Payment;
import co.cue.edu.miniproject.demo.dtos.PaymentDTO;
import co.cue.edu.miniproject.demo.jparepositories.PaymentRepositoryJPA;
import co.cue.edu.miniproject.demo.domain.mapping.PaymentMapper;
import co.cue.edu.miniproject.demo.services.impl.PaymentServiceImpl;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PaymentServiceImplTest {

    @Mock
    private PaymentRepositoryJPA paymentRepositoryJPA;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddPayment() {
        PaymentDTO paymentDTO = new PaymentDTO(null, null, null, null);

        paymentService.addPayment(paymentDTO);

        verify(paymentRepositoryJPA, times(1)).save(any(Payment.class));
    }

    @Test
    public void testRemovePay() {
        Long paymentId = 1L;

        paymentService.removePay(paymentId);

        verify(paymentRepositoryJPA, times(1)).deleteById(paymentId);
    }

    @Test
    public void testGetPay() {
        Payment payment1 = new Payment(1L, null, null, null);
        Payment payment2 = new Payment(2L, null, null, null);

        when(paymentRepositoryJPA.findAll()).thenReturn(Arrays.asList(payment1, payment2));

        List<PaymentDTO> paymentDTOList = paymentService.getPay();

        assertEquals(2, paymentDTOList.size());
        assertEquals(payment1.getIdPay(), paymentDTOList.get(0).idPay());
        assertEquals(payment2.getIdPay(), paymentDTOList.get(1).idPay());
    }

    @Test
    public void testFindById_PaymentExists() throws BadRequestException {
        Long paymentId = 1L;
        Payment payment = new Payment(paymentId, null, null, null);

        when(paymentRepositoryJPA.findById(paymentId)).thenReturn(Optional.of(payment));

        Payment foundPayment = paymentService.findById(paymentId);

        assertNotNull(foundPayment);
        assertEquals(paymentId, foundPayment.getIdPay());
    }

    @Test
    public void testFindById_PaymentNotExists() {
        Long paymentId = 1L;

        when(paymentRepositoryJPA.findById(paymentId)).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> paymentService.findById(paymentId));
    }
}
