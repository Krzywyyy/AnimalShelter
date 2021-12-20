package pl.krzywyyy.animalshelter.model.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class EmployeeRequest {
    private String firstName;
    private String surname;
    private String email;
    private String password;
    private Date employmentDate;
    private float salary;
}
