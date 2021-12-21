package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.krzywyyy.animalshelter.model.dto.request.EmployeeRequest;
import pl.krzywyyy.animalshelter.model.entity.Employee;
import pl.krzywyyy.animalshelter.repository.EmployeeRepository;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {EmployeeRepository.class}
)
public interface EmployeeMapper {
    @Mapping(target = "id", ignore = true)
    Employee requestToEntity(EmployeeRequest employeeRequest);
}
