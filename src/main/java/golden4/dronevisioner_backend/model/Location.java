package golden4.dronevisioner_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;
    private int postcode;
    private String streettname;
    private String streetnumber;

    @OneToMany(mappedBy = "Location", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
