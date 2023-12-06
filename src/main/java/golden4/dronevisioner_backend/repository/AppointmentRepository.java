package golden4.dronevisioner_backend.repository;

import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

  @Query("SELECT a FROM Appointment a JOIN a.customer c Join a.payment p")
  Page<Appointment> getAppointmentWithCustomerANDPayment(Pageable pageable);


}
