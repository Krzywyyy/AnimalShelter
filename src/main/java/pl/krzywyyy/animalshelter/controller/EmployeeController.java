package pl.krzywyyy.animalshelter.controller;

import lombok.RequiredArgsConstructor;
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
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.dto.update.EmployeeUpdate;
import pl.krzywyyy.animalshelter.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse save(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.save(employeeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeResponse> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeResponse getOne(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse update(@PathVariable int employeeId, @RequestBody EmployeeUpdate employeeUpdate) {
        return employeeService.update(employeeId, employeeUpdate);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
    }
}
