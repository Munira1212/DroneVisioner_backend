package golden4.dronevisioner_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Drone_ID;
    private int price;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Appointment appointment;

}
