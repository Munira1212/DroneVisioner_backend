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
    private LocalTime time;


    @OneToOne
    @JoinColumn(name = "captureDeviceid_fk")
    private CaptureDevice captureDevice;

    @OneToOne
    @JoinColumn(name = "customerid_fk")
    @JsonManagedReference
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "paymentid_fk")
    private Payment payment;



    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_ID=" + appointment_ID +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", time=" + time +
                // Assuming customer is an object
                '}';
    }



}
