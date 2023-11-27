package golden4.dronevisioner_backend.dto;

import golden4.dronevisioner_backend.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerConverter {


    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomer_ID(customerDTO.customer_ID());
        customer.setFirst_Name(customerDTO.first_Name());
        customer.setLast_Name(customerDTO.last_Name());
        customer.setBirthday(customerDTO.birthday());
        customer.setEmail(customerDTO.email());
        customer.setPhoneNumber(customerDTO.phoneNumber());
        customer.setRegistration_date(customerDTO.registration_date());
        return customer;
    }



    public CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
               customer.getCustomer_ID(),
                customer.getFirst_Name(),
                customer.getLast_Name(),
                customer.getBirthday(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getRegistration_date());
    }
}
