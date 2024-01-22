package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.dto.AppointmentDTO;
//import golden4.dronevisioner_backend.dto.PaymentConverter;
import golden4.dronevisioner_backend.dto.PaymentDTO;
import golden4.dronevisioner_backend.expcetion.PaymentNotFoundException;
import golden4.dronevisioner_backend.model.Payment;
import golden4.dronevisioner_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService
{

    private PaymentRepository paymentRepository;
    //private PaymentConverter paymentConverter; // Assuming you have a PaymentConverter

    /*@Autowired
    public PaymentService(PaymentRepository paymentRepository, PaymentConverter paymentConverter) {
        this.paymentRepository = paymentRepository;
        this.paymentConverter = paymentConverter;
    }*/

    public double getPriceForPayment(int paymentId)
    {
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);

        if (paymentOptional.isPresent())
        {
            return paymentOptional.get().getPrice();
        }
        else
        {
            throw new PaymentNotFoundException("Payment not found with id: " + paymentId);
        }
    }

}

    /*public PaymentDTO updatePriceForPayment(int paymentId, double newPrice) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + paymentId));

        payment.setPrice((int) newPrice);
        Payment savedPayment = paymentRepository.save(payment);

        // Assuming you have a PaymentConverter, you can convert it to DTO
        PaymentDTO updatedPaymentDTO = paymentConverter.toDTO(savedPayment);
        return updatedPaymentDTO;
    }


    public PaymentDTO createPayment(PaymentDTO paymentDTO){
    Payment paymentToSave = paymentConverter.toEntity(paymentDTO);
        // ensure it's a create

        Payment savedPayment = paymentRepository.save(paymentToSave);

        return paymentConverter.toDTO(savedPayment);
    }

}

/*

    public PaymentDTO updatePriceForPayment(int paymentId, double newPrice) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + paymentId));

        payment.setPrice(newPrice);
        Payment savedPayment = paymentRepository.save(payment);

        return paymentConverter.toDTO(savedPayment);
    }

 */




