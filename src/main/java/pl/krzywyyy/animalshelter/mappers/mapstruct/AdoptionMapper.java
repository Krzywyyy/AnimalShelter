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

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {AnimalRepository.class,
                ClientRepository.class,
                EmployeeRepository.class
        }
)
public interface AdoptionMapper {
    @Mappings({
            @Mapping(target = "animal", ignore = true),
            @Mapping(target = "client", ignore = true),
            @Mapping(target = "employee", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    Adoption requestToEntity(CreateAdoptionCommand createAdoptionCommand);

    AdoptionResponse entityToResponse(Adoption adoption);
}
