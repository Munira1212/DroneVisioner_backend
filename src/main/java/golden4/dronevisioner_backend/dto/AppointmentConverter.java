package golden4.dronevisioner_backend.dto;

import golden4.dronevisioner_backend.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AppointmentConverter
{
    public Appointment toEntity(AppointmentDTO appointmentDTO){
        Appointment appointment = new Appointment();
        appointment.setDate(appointmentDTO.date());


        return appointment;
    }

    public AppointmentDTO toDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getAppointment_ID(), appointment.getDate());
        return appointmentDTO;
    }
}
