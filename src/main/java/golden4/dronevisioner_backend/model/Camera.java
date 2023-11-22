package golden4.dronevisioner_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int camera_ID;

    @OneToOne(mappedBy = "camera")
    private Appointment appointment;



}
