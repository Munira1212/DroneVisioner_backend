package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @PostMapping()
    public ResponseEntity<AppointmentDTO> makeAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO createdAppointment = appointmentService.createAppointment(appointmentDTO);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @GetMapping("getAllAppointments")
    public ResponseEntity getAppointmentWithCustomerANDPayment(Pageable pageable) {
        return new ResponseEntity<>(appointmentService.getAppointmentWithCustomerANDPayment( pageable), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{appointment_ID}")
    public ResponseEntity deleteAppointmentAndCustomers(@PathVariable int appointment_ID){
        appointmentService.deleteAppointmentAndCustomers(appointment_ID);
      //  return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Appointment with id " + appointment_ID + " was deleted");
        return ResponseEntity.ok("Showtime with id " + appointment_ID + " was deleted");
    }
}
