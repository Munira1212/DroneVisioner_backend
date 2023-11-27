package golden4.dronevisioner_backend.dto;

import java.time.LocalDate;

public record CustomerDTO( int customer_ID,String first_Name,String last_Name,String birthday,String email,String phoneNumber, String registration_date) {

}
