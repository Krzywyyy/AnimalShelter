package pl.krzywyyy.animalshelter.model.dto.update;

import lombok.Getter;

import java.util.Date;

@Getter
public class EmployeeUpdate {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
    private Date endDateOfWork;
    private String jobPosition;
    private float salary;
}
