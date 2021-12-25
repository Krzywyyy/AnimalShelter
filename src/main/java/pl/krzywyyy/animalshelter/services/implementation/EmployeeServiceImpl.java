package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.EmployeeMapper;
import pl.krzywyyy.animalshelter.model.dto.request.EmployeeRequest;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.dto.update.EmployeeUpdate;
import pl.krzywyyy.animalshelter.repository.EmployeeRepository;
import pl.krzywyyy.animalshelter.services.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public EmployeeResponse findById(int id) {
        return null;
    }

    @Override
    public List<EmployeeResponse> findAll() {
        return null;
    }

    @Override
    public EmployeeResponse update(int employeeId, EmployeeUpdate employeeUpdate) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
