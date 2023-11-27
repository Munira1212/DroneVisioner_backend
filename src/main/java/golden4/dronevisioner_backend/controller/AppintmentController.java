package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.dto.CustomerDTO;
import golden4.dronevisioner_backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AppintmentController {

    @Autowired
    AppointmentService appointmentService;


    @PostMapping("/location")
    public ResponseEntity<AppointmentDTO> registerLocation(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO registeredAppointment = appointmentService.registerAppointment(appointmentDTO);
        return new ResponseEntity<>(registeredAppointment, HttpStatus.CREATED);
    }
}
