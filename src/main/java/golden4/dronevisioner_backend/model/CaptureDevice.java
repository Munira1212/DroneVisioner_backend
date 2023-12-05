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
public class CaptureDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int captureDevice_ID;
    private String brand;
    private String version;


   /* @OneToMany(mappedBy = "captureDevice", cascade = CascadeType.ALL)
    private List<Appointment> appointments;*/

    @ManyToOne
    @JoinColumn(name = "visualMediaTypefk_ID")
    private VisualMediaType visualMediaType;

    @OneToOne(mappedBy = "captureDevice", cascade = CascadeType.ALL)
    @JsonBackReference
    private Appointment appointment;


}
