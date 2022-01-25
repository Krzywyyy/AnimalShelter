package pl.krzywyyy.animalshelter.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDetails {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
    private Date employmentDate;
    private Date endDateOfWork;
    private String jobPosition;
    private float salary;
}
