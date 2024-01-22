package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.dto.PaymentDTO;
import golden4.dronevisioner_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
//@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

   /* @GetMapping("/{paymentId}/price")
    public ResponseEntity<Double> getPriceForPayment(@PathVariable int paymentId) {
        double price = paymentService.getPriceForPayment(paymentId);
        return ResponseEntity.ok(price);
    }*/

   /* @PostMapping("/updatePrice")
    public ResponseEntity<Void> updatePriceForPayment(@RequestBody Map<String, Double> data) {
        double newPrice = data.get("newPrice");
        // Your implementation to update the price
        return ResponseEntity.ok().build();
    }*/

    /*@PostMapping("/updatePrice")
    public ResponseEntity<PaymentDTO> makeAppointment(@RequestBody PaymentDTO paymentDTO) {
       PaymentDTO createdPayment = paymentService.createPayment(paymentDTO);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }*/



    /*@PostMapping("/{paymentId}/updatePrice/{newPrice}")
    public ResponseEntity<PaymentDTO> updatePriceForPayment(
            @PathVariable int paymentId,
            @PathVariable double newPrice) {
        PaymentDTO updatedPayment = paymentService.updatePriceForPayment(paymentId, newPrice);
        return ResponseEntity.ok(updatedPayment);
    }*/
}

