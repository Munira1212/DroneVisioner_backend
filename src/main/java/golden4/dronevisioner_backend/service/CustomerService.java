package golden4.dronevisioner_backend.service;
import golden4.dronevisioner_backend.dto.CustomerConverter;
import golden4.dronevisioner_backend.dto.CustomerDTO;
import golden4.dronevisioner_backend.model.Customer;
import golden4.dronevisioner_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final CustomerConverter customerConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        Customer customer = customerConverter.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerConverter.toDTO(savedCustomer);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerConverter::toDTO)
                .collect(Collectors.toList());
    }
}
