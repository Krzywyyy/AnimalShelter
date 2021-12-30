package pl.krzywyyy.animalshelter.model.dto.request;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class EmployeeRequest {
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private Date employmentDate;
    private String jobPosition;
    private float salary;
}
