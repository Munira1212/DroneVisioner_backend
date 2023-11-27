package golden4.dronevisioner_backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private LocalTime time; //rettet til time


    @OneToOne
    @JoinColumn(name = "droneid_fk", nullable = true)
    //@JsonManagedReference
    private Drone drone;


    @OneToOne
    @JoinColumn(name = "customerid_fk", nullable = true)
    //@JsonManagedReference
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "cameraid_fk", nullable = true)
    //@JsonManagedReference
    private Camera camera;

    @OneToOne
    @JoinColumn(name = "paymentid_fk", nullable = true)
    private Payment payment;

   /* @OneToMany
    @JoinColumn(name = "locations_fk", nullable = false)
    private List<Location> locations;

*/



}
