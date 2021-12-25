package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.EmployeeRequest;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.dto.update.EmployeeUpdate;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse save(EmployeeRequest employeeRequest);

    EmployeeResponse findById(int id);

    List<EmployeeResponse> findAll();

    EmployeeResponse update(int employeeId, EmployeeUpdate employeeUpdate);

    boolean delete(int id);
}
