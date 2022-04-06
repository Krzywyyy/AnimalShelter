package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.mappers.PasswordMapper;
import pl.krzywyyy.animalshelter.mappers.annotations.PasswordEncoder;
import pl.krzywyyy.animalshelter.model.dto.commands.CreateEmployeeCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeDetails;
import pl.krzywyyy.animalshelter.model.dto.responses.EmployeeResponse;
import pl.krzywyyy.animalshelter.model.entities.Employee;
import pl.krzywyyy.animalshelter.repositories.RoleRepository;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                PasswordMapper.class,
                RoleRepository.class
        }
)
public interface EmployeeMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "password", qualifiedBy = PasswordEncoder.class),
            @Mapping(target = "roles", ignore = true),
            @Mapping(target = "endDateOfWork", ignore = true),
            @Mapping(target = "supervisedAdoptions", ignore = true)
    })
    Employee requestToEntity(CreateEmployeeCommand createEmployeeCommand);

    EmployeeResponse entityToResponse(Employee employee);

    EmployeeDetails entityToDetails(Employee employee);
}
