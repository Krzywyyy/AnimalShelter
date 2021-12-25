package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.request.AdoptionRequest;
import pl.krzywyyy.animalshelter.model.entity.Adoption;
import pl.krzywyyy.animalshelter.repository.AnimalRepository;
import pl.krzywyyy.animalshelter.repository.ClientRepository;
import pl.krzywyyy.animalshelter.repository.EmployeeRepository;

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
    Adoption requestToEntity(AdoptionRequest adoptionRequest);
}
