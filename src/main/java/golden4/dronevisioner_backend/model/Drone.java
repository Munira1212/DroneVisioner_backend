package golden4.dronevisioner_backend.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Drone_ID;


}
