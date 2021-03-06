package pl.krzywyyy.animalshelter.model.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
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
