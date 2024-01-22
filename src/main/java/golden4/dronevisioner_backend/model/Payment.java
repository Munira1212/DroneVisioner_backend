package golden4.dronevisioner_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private int payment_ID;  // Corrected the field name to match Appointment

    private double price;


    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    @JsonBackReference
    private Appointment appointment;
}

