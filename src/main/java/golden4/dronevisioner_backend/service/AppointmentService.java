package golden4.dronevisioner_backend.service;
import golden4.dronevisioner_backend.dto.AppointmentConverter;
import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.repository.AppointmentRepository;
import golden4.dronevisioner_backend.repository.CaptureDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AppointmentService
{
    private final AppointmentRepository appointmentRepository;

    private final AppointmentConverter appointmentConverter;
    private final CaptureDeviceRepository captureDeviceRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter, CaptureDeviceRepository captureDeviceRepository){

        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
        this.captureDeviceRepository = captureDeviceRepository;
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {

        // Convert DTO to entity
        Appointment appointmentToSave = appointmentConverter.toEntity(appointmentDTO);

        System.out.println("DTO before saving: " + appointmentDTO);

// Save the appointment
        Appointment savedAppointment = appointmentRepository.save(appointmentToSave);

// Log the saved entity after saving
        System.out.println("Saved Entity: " + savedAppointment);

        // Convert the saved entity back to DTO
        return appointmentConverter.toDTO(savedAppointment);
    }







        public Page<AppointmentDTO> getAllAppointments(Pageable pageable) {
        Page<Appointment> appointmentsPage = appointmentRepository.findAll(pageable);
        return appointmentsPage.map(appointmentConverter::toDTO);
    }

    public Page<AppointmentDTO> getAppointmentWithCustomerANDPayment(Pageable pageable) {
        Page<Appointment> appointments = appointmentRepository.getAppointmentWithCustomerANDPayment(pageable);
        return appointments.map(appointmentConverter::toDTO);
    }


    @DeleteMapping("/delete/{appointment_ID}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int appointment_ID) {
        try {
            Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointment_ID);

            if (optionalAppointment.isPresent()) {
                appointmentRepository.deleteById(appointment_ID);
                return ResponseEntity.ok("Appointment with id " + appointment_ID + " was deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found with id " + appointment_ID);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting appointment with id " + appointment_ID);
        }
    }


    public AppointmentDTO getAppointmentById(int AppointmentId) {
        Appointment appointment = appointmentRepository.findById(AppointmentId)
                .orElseThrow(() -> new RuntimeException("CaptureDevice not found"));

        return appointmentConverter.toDTO(appointment);
        // convertEntityToDTO(captureDevice);
    }


    public AppointmentDTO updateAppointment(int appointment_ID, AppointmentDTO appointmentDTO) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointment_ID);

        if (optionalAppointment.isPresent()) {
            Appointment appointmentToUpdate = appointmentConverter.toEntity(appointmentDTO);
            appointmentToUpdate.setAppointment_ID(appointment_ID);
            appointmentRepository.save(appointmentToUpdate);
            return appointmentConverter.toDTO(appointmentToUpdate);
        } else {
            throw new IllegalArgumentException("Appointment not found: " + appointment_ID);
        }
    }




}