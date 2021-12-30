package pl.krzywyyy.animalshelter.controller;

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
import pl.krzywyyy.animalshelter.model.dto.request.EmployeeRequest;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.dto.update.EmployeeUpdate;
import pl.krzywyyy.animalshelter.service.EmployeeService;

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
    public EmployeeResponse save(@RequestBody EmployeeRequest employeeRequest) {
        logger.debug(String.format("[HTTP_POST]: Create new employee = [%s]", employeeRequest.toString()));
        return employeeService.save(employeeRequest);
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
    public EmployeeResponse update(@PathVariable int employeeId, @RequestBody EmployeeUpdate employeeUpdate) {
        logger.debug(String.format("[HTTP_PUT]: Updating employee with id = [%s], new values = [%s]", employeeId, employeeUpdate.toString()));
        return employeeService.update(employeeId, employeeUpdate);
    }

    @PutMapping("/{employeeId}/dismiss")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDetails dismiss(@PathVariable int employeeId, @RequestBody Date dismissalDate) {
        logger.debug(String.format("[HTTP_PUT]: Dismissing employee with id = [%s], dismissal date = [%s]", employeeId, dismissalDate));
        return employeeService.dismiss(employeeId, dismissalDate);
    }

    @PutMapping("/{employeeId}/uec")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDetails updateEmploymentConditions(@PathVariable int employeeId, @RequestBody EmployeeUpdate employeeUpdate) {
        logger.debug(String.format("[HTTP_PUT]: Updating employment conditions of employee with id = [%s], new conditions = [%s]", employeeId, employeeUpdate.toString()));
        return employeeService.updateEmploymentConditions(employeeId, employeeUpdate);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int employeeId) {
        logger.debug(String.format("[HTTP_DELETE]: Deleting employee with id = [%s]", employeeId));
        employeeService.delete(employeeId);
    }
}
