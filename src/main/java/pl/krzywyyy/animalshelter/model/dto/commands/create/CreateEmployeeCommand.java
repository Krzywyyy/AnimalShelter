package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public final class CreateEmployeeCommand {
    private final String firstName;
    private final String surname;
    private final String phoneNumber;
    private final String email;
    private final String password;
    private final Date employmentDate;
    private final String jobPosition;
    private final float salary;
}
