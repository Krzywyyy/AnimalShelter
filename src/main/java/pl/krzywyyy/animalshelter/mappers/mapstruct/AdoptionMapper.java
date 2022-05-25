package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAdoptionCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AdoptionResponse;
import pl.krzywyyy.animalshelter.model.entities.Adoption;
import pl.krzywyyy.animalshelter.repositories.AnimalRepository;
import pl.krzywyyy.animalshelter.repositories.ClientRepository;
import pl.krzywyyy.animalshelter.repositories.EmployeeRepository;
import pl.krzywyyy.animalshelter.repositories.jpamapstructfix.ById;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                AnimalRepository.class,
                ClientRepository.class,
                EmployeeRepository.class
        }
)
public interface AdoptionMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "animalId", target = "animal", qualifiedBy = ById.class),
            @Mapping(source = "clientId", target = "client", qualifiedBy = ById.class),
            @Mapping(source = "employeeId", target = "employee", qualifiedBy = ById.class)
    })
    Adoption requestToEntity(CreateAdoptionCommand createAdoptionCommand);

    @Mappings({
            @Mapping(source = "adoption.animal.id", target = "animalId"),
            @Mapping(source = "adoption.client.id", target = "clientId"),
            @Mapping(source = "adoption.employee.id", target = "employeeId")
    })
    AdoptionResponse entityToResponse(Adoption adoption);
}
