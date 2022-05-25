package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateEmployeeCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.EmployeeUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeResponse;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    void save(CreateEmployeeCommand createEmployeeCommand);

    EmployeeResponse findById(int employeeId);

    List<EmployeeResponse> findAll();

    EmployeeResponse update(int employeeId, EmployeeUpdateCommand employeeUpdateCommand);

    EmployeeDetails dismiss(int employeeId, Date dismissalDate);

    EmployeeDetails updateEmploymentConditions(int employeeId, EmployeeUpdateCommand employeeUpdateCommand);

    void delete(int employeeId);
}
