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
public class VisualMediaType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visualMediaType_ID;
    private String  type_Name;

   /* @OneToMany(mappedBy = "visualMediaType", cascade = CascadeType.ALL)
    private List<CaptureDevice> captureDevices;*/

}
