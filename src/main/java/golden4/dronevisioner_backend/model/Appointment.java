package golden4.dronevisioner_backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_ID;
    private String description;
    private LocalDate date;
    private LocalDateTime time;


    /*@ManyToOne
    @JoinColumn(name = "captureDeviceid_fk")
    private CaptureDevice captureDevice;*/

    @OneToOne
    @JoinColumn(name = "customerid_fk", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "paymentid_fk", nullable = false)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "locations_fk")
    private Location location;  // Updated to follow naming conventions


}
