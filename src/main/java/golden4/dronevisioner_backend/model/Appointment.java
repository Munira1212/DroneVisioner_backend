package golden4.dronevisioner_backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    private String location;
    private String description;
    private LocalDate date;
    private LocalDate time;


    @ManyToOne
    @JoinColumn(name = "captureDeviceid_fk")
    private CaptureDevice captureDevice;

    @OneToOne
    @JoinColumn(name = "customerid_fk", nullable = false)
    //@JsonManagedReference
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "paymentid_fk", nullable = false)
    private Payment payment;

    @OneToMany
    @JoinColumn(name = "locations_fk", nullable = false)
    private List<Location> locations;





}
