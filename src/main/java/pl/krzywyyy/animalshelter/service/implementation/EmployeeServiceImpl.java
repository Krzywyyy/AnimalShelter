package pl.krzywyyy.animalshelter.service.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.EmployeeMapper;
import pl.krzywyyy.animalshelter.model.dto.request.EmployeeRequest;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.dto.update.EmployeeUpdate;
import pl.krzywyyy.animalshelter.model.entity.Employee;
import pl.krzywyyy.animalshelter.repository.EmployeeRepository;
import pl.krzywyyy.animalshelter.service.EmployeeService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final Logger logger;

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        return employeeMapper.entityToResponse(
                employeeRepository.save(
                        employeeMapper.requestToEntity(employeeRequest)
                )
        );
    }

    @Override
    public EmployeeResponse findById(int employeeId) {
        return employeeMapper.entityToResponse(
                employeeRepository.getById(employeeId)
        );
    }

    @Override
    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse update(int employeeId, EmployeeUpdate employeeUpdate) {
        final Employee employee = employeeRepository.getById(employeeId);
        employee.setFirstName(employeeUpdate.getFirstName());
        employee.setSurname(employeeUpdate.getSurname());
        employee.setPhoneNumber(employeeUpdate.getPhoneNumber());
        employee.setEmail(employeeUpdate.getEmail());
        final Employee updated = employeeRepository.save(employee);
        return employeeMapper.entityToResponse(updated);
    }

    @Override
    public EmployeeDetails dismiss(int employeeId, Date dismissalDate) {
        final Employee employee = employeeRepository.getById(employeeId);
        employee.setEndDateOfWork(dismissalDate);
        final Employee dismissed = employeeRepository.save(employee);
        return employeeMapper.entityToDetails(dismissed);
    }

    @Override
    public EmployeeDetails updateEmploymentConditions(int employeeId, EmployeeUpdate employeeUpdate) {
        final Employee employee = employeeRepository.getById(employeeId);
        employee.setJobPosition(employeeUpdate.getJobPosition());
        employee.setSalary(employeeUpdate.getSalary());
        final Employee updated = employeeRepository.save(employee);
        return employeeMapper.entityToDetails(updated);
    }

    @Override
    public void delete(int employeeId) {
        employeeRepository.delete(
                employeeRepository.getById(employeeId)
        );
    }
}
