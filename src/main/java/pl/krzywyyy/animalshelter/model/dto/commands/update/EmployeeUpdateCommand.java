package pl.krzywyyy.animalshelter.model.dto.commands.update;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class EmployeeUpdateCommand {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
    private Date endDateOfWork;
    private String jobPosition;
    private float salary;
}
