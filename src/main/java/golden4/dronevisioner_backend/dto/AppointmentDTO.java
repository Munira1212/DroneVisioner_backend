package golden4.dronevisioner_backend.dto;

import java.time.LocalDate;

public record AppointmentDTO(int appointment_ID,String location,String description,LocalDate date,LocalDate time) {

}
