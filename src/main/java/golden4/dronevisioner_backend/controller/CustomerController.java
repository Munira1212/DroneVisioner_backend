package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.CustomerDTO;
import golden4.dronevisioner_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO registeredCustomer = customerService.registerCustomer(customerDTO);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

}
