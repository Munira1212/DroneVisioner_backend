package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.dto.AppointmentConverter;
import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.dto.CaptureDeviceDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.repository.AppointmentRepository;
import golden4.dronevisioner_backend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService
{
    private final AppointmentRepository appointmentRepository;

    private final AppointmentConverter appointmentConverter;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter){

        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO){
        Appointment appointmentToSave = appointmentConverter.toEntity(appointmentDTO);

        // ensure it's a create
        appointmentToSave.setAppointment_ID(0);

        Appointment savedAppointment = appointmentRepository.save(appointmentToSave);

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
}