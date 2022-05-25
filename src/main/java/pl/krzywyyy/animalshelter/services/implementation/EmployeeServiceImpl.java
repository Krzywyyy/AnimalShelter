package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mappers.mapstruct.EmployeeMapper;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateEmployeeCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.EmployeeUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.entities.Employee;
import pl.krzywyyy.animalshelter.repositories.EmployeeRepository;
import pl.krzywyyy.animalshelter.repositories.RoleRepository;
import pl.krzywyyy.animalshelter.security.roles.SecurityRole;
import pl.krzywyyy.animalshelter.services.EmployeeService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final EmployeeMapper employeeMapper;
    private final Logger logger;

    @Override
    public void save(CreateEmployeeCommand createEmployeeCommand) {
        logger.debug(String.format("Saving employee = [%s] to database", createEmployeeCommand.toString()));
        final Employee employee = employeeMapper.requestToEntity(createEmployeeCommand);
        employee.setRoles(List.of(roleRepository.findByName(SecurityRole.ROLE_EMPLOYEE.name())));
        employeeRepository.save(employee);
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
    public EmployeeResponse update(int employeeId, EmployeeUpdateCommand employeeUpdateCommand) {
        final Employee employee = employeeRepository.getById(employeeId);
        employee.setFirstName(employeeUpdateCommand.getFirstName());
        employee.setSurname(employeeUpdateCommand.getSurname());
        employee.setPhoneNumber(employeeUpdateCommand.getPhoneNumber());
        employee.setEmail(employeeUpdateCommand.getEmail());
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
    public EmployeeDetails updateEmploymentConditions(int employeeId, EmployeeUpdateCommand employeeUpdateCommand) {
        final Employee employee = employeeRepository.getById(employeeId);
        employee.setJobPosition(employeeUpdateCommand.getJobPosition());
        employee.setSalary(employeeUpdateCommand.getSalary());
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
