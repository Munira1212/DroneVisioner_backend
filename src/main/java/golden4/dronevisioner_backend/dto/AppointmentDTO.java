package golden4.dronevisioner_backend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AppointmentDTO(int appointment_ID,String location,String description,LocalDate date, LocalTime time)
{

}
