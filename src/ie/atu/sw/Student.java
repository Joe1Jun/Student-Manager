package ie.atu.sw;

import java.time.LocalDate;

public record Student (String sid, String firstname, String surname, LocalDate dob,Address address, Course course  ) {

}
