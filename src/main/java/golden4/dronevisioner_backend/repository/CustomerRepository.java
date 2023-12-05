package golden4.dronevisioner_backend.repository;

import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    void deleteByAppointment(Appointment appointment);
}
