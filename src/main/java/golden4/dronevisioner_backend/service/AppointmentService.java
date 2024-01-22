package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.dto.AppointmentConverter;
import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.repository.AppointmentRepository;
import golden4.dronevisioner_backend.repository.CaptureDeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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





    public List<LocalDate> getBookedDates() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(Appointment::getDate)
                .collect(Collectors.toList());
    }


    public Page<AppointmentDTO> getAllAppointments(Pageable pageable) {
        Page<Appointment> appointments = appointmentRepository.getAllAppointments(pageable);
        return appointments.map(appointmentConverter::toDTO);
    }


    public Appointment deleteAppointment(int appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            appointmentRepository.deleteById(appointmentId);

            System.out.println("Deleted appointment with id: " + appointmentId);
            return optionalAppointment.get();
        } else {
            throw new IllegalArgumentException("Appointment not found with id: " + appointmentId);
        }
    }
    public AppointmentDTO getAppointmentById(int AppointmentId) {
        Appointment appointment = appointmentRepository.findById(AppointmentId)
                .orElseThrow(() -> new RuntimeException("CaptureDevice not found"));

        return appointmentConverter.toDTO(appointment);
        // convertEntityToDTO(captureDevice);
    }

//god til eksamen frø!!!
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