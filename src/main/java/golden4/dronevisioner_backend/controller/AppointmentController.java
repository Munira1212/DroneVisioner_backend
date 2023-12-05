package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.service.AppointmentService;
import golden4.dronevisioner_backend.service.CaptureDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;
    @Autowired
    private CaptureDeviceService captureDeviceService;


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
    public ResponseEntity deleteAppointment(@PathVariable int appointment_ID){
        appointmentService.deleteAppointment(appointment_ID);
      //  return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Appointment with id " + appointment_ID + " was deleted");
        return ResponseEntity.ok("appointment with id " + appointment_ID + " was deleted");
    }
}

    /*public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            // Save the CaptureDevice first
            CaptureDevice savedCaptureDeviceEntity = captureDeviceService.saveCaptureDevice(appointmentCo;

            // Update the appointmentDTO with the saved CaptureDevice
            appointmentDTO.setCaptureDevice(captureDeviceConverter.toDTO(savedCaptureDeviceEntity));

            // Save the Appointment
            AppointmentDTO savedAppointmentDTO = appointmentService.createAppointment(appointmentDTO);

            return new ResponseEntity<>(savedAppointmentDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }*/