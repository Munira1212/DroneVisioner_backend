package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.dto.CaptureDeviceDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.model.CaptureDevice;
import golden4.dronevisioner_backend.service.AppointmentService;
import golden4.dronevisioner_backend.service.CaptureDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/appointment")
public class AppointmentController
{

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    private CaptureDeviceService captureDeviceService;


   /* @PostMapping()
    public ResponseEntity<AppointmentDTO> makeAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO createdAppointment = appointmentService.createAppointment(appointmentDTO);
        System.out.println(createdAppointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }*/


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
}
