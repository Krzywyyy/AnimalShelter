package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.entity.Adoption;
import pl.krzywyyy.animalshelter.repository.AdoptionRepository;
import pl.krzywyyy.animalshelter.repository.AnimalRepository;
import pl.krzywyyy.animalshelter.repository.ClientRepository;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                AdoptionRepository.class,
                AnimalRepository.class,
                ClientRepository.class
        }
)
public interface AdoptionMapper {
    @Mappings({
            @Mapping(source = "animalId", target = "animal"),
            @Mapping(source = "clientId", target = "client"),
            @Mapping(target = "id", ignore = true)
    })
    Adoption requestToEntity(AdoptionRepository adoptionRepository);
}
