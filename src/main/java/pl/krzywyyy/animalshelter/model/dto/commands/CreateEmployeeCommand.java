package pl.krzywyyy.animalshelter.model.dto.commands;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class CreateEmployeeCommand {
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private Date employmentDate;
    private String jobPosition;
    private float salary;
}
