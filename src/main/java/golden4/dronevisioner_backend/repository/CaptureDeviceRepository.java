package golden4.dronevisioner_backend.repository;

import golden4.dronevisioner_backend.model.CaptureDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptureDeviceRepository extends JpaRepository<CaptureDevice, Integer> {
}
