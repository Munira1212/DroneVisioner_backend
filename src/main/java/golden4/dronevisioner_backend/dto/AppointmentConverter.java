package golden4.dronevisioner_backend.dto;

import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class AppointmentConverter {
    public Appointment toEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setAppointment_ID(appointmentDTO.appointment_ID());
        appointment.setLocation(appointmentDTO.location());
        appointment.setDescription(appointmentDTO.description());
        appointment.setDate(appointmentDTO.date());
        appointment.setTime(appointmentDTO.time());
        appointment.setCustomer(appointmentDTO.customer());
        //appointment.setPayment(appointmentDTO.);
        return appointment;
    }



    public AppointmentDTO toDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getAppointment_ID(),
                appointment.getLocation(),
                appointment.getDescription(),
                appointment.getDate(),
                appointment.getTime(),
               appointment.getCustomer());
                //appointment.getPayment());
    }

}
