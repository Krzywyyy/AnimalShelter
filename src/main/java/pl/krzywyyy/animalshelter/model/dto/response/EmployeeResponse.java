package pl.krzywyyy.animalshelter.model.dto.response;

import lombok.Setter;

import java.util.Date;

@Setter
public class EmployeeResponse {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
    private Date employmentDate;
    private Date endDateOfWork;
    private String jobPosition;
    private float salary;
}
