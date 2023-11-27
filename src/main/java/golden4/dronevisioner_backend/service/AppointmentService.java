package golden4.dronevisioner_backend.service;
import golden4.dronevisioner_backend.dto.AppointmentConverter;
import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {


    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private final AppointmentConverter appointmentConverter;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
    }

    public AppointmentDTO registerAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentConverter.toEntity(appointmentDTO);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentConverter.toDTO(savedAppointment);
    }
}
