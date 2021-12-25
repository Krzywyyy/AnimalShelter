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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

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
        return null;
    }

    @Override
    public void delete(int employeeId) {
        employeeRepository.delete(
                employeeRepository.getById(employeeId)
        );
    }
}
