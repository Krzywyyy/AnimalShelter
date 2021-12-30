package pl.krzywyyy.animalshelter.service;

import pl.krzywyyy.animalshelter.model.dto.request.EmployeeRequest;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.dto.update.EmployeeUpdate;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    EmployeeResponse save(EmployeeRequest employeeRequest);

    EmployeeResponse findById(int employeeId);

    List<EmployeeResponse> findAll();

    EmployeeResponse update(int employeeId, EmployeeUpdate employeeUpdate);

    EmployeeDetails dismiss(int employeeId, Date dismissalDate);

    EmployeeDetails updateEmploymentConditions(int employeeId, EmployeeUpdate employeeUpdate);

    void delete(int employeeId);
}
