package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.request.EmployeeRequest;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.response.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.entity.Employee;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface EmployeeMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "endDateOfWork", ignore = true),
            @Mapping(target = "supervisedAdoptions", ignore = true)
    })
    Employee requestToEntity(EmployeeRequest employeeRequest);

    EmployeeResponse entityToResponse(Employee employee);

    EmployeeDetails entityToDetails(Employee employee);
}
