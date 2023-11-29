package golden4.dronevisioner_backend.repository;

import golden4.dronevisioner_backend.model.VisualMediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualMediaTypeRepository extends JpaRepository<VisualMediaType, Integer> {
    //VisualMediaType findBySomeOtherAttribute(String type_Name);
}