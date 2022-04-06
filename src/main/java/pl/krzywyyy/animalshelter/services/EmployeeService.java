package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.CreateEmployeeCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.dto.updates.EmployeeUpdate;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    EmployeeResponse save(CreateEmployeeCommand createEmployeeCommand);

    EmployeeResponse findById(int employeeId);

    List<EmployeeResponse> findAll();

    EmployeeResponse update(int employeeId, EmployeeUpdate employeeUpdate);

    EmployeeDetails dismiss(int employeeId, Date dismissalDate);

    EmployeeDetails updateEmploymentConditions(int employeeId, EmployeeUpdate employeeUpdate);

    void delete(int employeeId);
}
