package golden4.dronevisioner_backend.repository;

import golden4.dronevisioner_backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

  @Query("SELECT a FROM Appointment a JOIN a.customer")
  Page<Appointment> getAllAppointments(Pageable pageable);


}
