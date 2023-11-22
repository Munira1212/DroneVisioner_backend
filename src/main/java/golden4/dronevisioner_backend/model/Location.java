package golden4.dronevisioner_backend.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;


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

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
