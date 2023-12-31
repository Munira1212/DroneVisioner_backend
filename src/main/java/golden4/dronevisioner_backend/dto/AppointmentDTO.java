package golden4.dronevisioner_backend.dto;

import golden4.dronevisioner_backend.model.CaptureDevice;
import golden4.dronevisioner_backend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public record AppointmentDTO(int appointment_ID, String location, String description, LocalDate date, LocalTime time, Customer customer, CaptureDevice captureDevice)
{


}
