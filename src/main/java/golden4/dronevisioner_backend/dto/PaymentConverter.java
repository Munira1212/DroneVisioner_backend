package golden4.dronevisioner_backend.dto;
import golden4.dronevisioner_backend.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {

    public Payment toEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setDrone_ID(paymentDTO.drone_ID());
        payment.setPrice((int) paymentDTO.price());
        return payment;
    }

    public PaymentDTO toDTO(Payment payment) {
        return new PaymentDTO(
                payment.getDrone_ID(),
                payment.getPrice());

    }
}


/*

    public CustomerDTO toDTO(Customer customer){
        return new CustomerDTO(
                customer.getCustomer_ID(),
                customer.getFirst_Name(),
                customer.getLast_Name(),
                customer.getBirthday(),
                customer.getEmail()
        );
    }
}

 */
