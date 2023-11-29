package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.dto.AppointmentConverter;
import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
