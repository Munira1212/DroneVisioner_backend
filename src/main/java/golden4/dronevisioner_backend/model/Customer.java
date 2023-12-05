package golden4.dronevisioner_backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_ID;
    private String first_Name;
    private String last_Name;
    private String birthday;
    private String email;
    private String phoneNumber;
    private String registration_date;


   @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
   @JsonBackReference
   private Appointment appointment;




}