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
    private int drone_ID;
    private double price;


    @OneToOne(mappedBy = "payment")
    private Appointment appointment;
}

