package golden4.dronevisioner_backend.repository;

import golden4.dronevisioner_backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>
{
}
