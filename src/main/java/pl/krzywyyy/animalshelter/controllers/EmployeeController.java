package pl.krzywyyy.animalshelter.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateEmployeeCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.EmployeeUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeResponse;
import pl.krzywyyy.animalshelter.services.EmployeeService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Logger logger;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CreateEmployeeCommand createEmployeeCommand) {
        logger.debug(String.format("[HTTP_POST]: Create new employee = [%s]", createEmployeeCommand.toString()));
        employeeService.save(createEmployeeCommand);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeResponse> findAll() {
        logger.debug("[HTTP_GET]: Listing all employees");
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeResponse findById(@PathVariable int employeeId) {
        logger.debug(String.format("[HTTP_GET]: Find employee with id = [%s]", employeeId));
        return employeeService.findById(employeeId);
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse update(@PathVariable int employeeId, @RequestBody EmployeeUpdateCommand employeeUpdateCommand) {
        logger.debug(String.format("[HTTP_PUT]: Updating employee with id = [%s], new values = [%s]", employeeId, employeeUpdateCommand.toString()));
        return employeeService.update(employeeId, employeeUpdateCommand);
    }

    @PutMapping("/{employeeId}/dismiss")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDetails dismiss(@PathVariable int employeeId, @RequestBody Date dismissalDate) {
        logger.debug(String.format("[HTTP_PUT]: Dismissing employee with id = [%s], dismissal date = [%s]", employeeId, dismissalDate));
        return employeeService.dismiss(employeeId, dismissalDate);
    }

    @PutMapping("/{employeeId}/uec")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDetails updateEmploymentConditions(@PathVariable int employeeId, @RequestBody EmployeeUpdateCommand employeeUpdateCommand) {
        logger.debug(String.format("[HTTP_PUT]: Updating employment conditions of employee with id = [%s], new conditions = [%s]", employeeId, employeeUpdateCommand.toString()));
        return employeeService.updateEmploymentConditions(employeeId, employeeUpdateCommand);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int employeeId) {
        logger.debug(String.format("[HTTP_DELETE]: Deleting employee with id = [%s]", employeeId));
        employeeService.delete(employeeId);
    }
}
