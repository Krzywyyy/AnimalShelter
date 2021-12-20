package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.krzywyyy.animalshelter.model.dto.AnimalRequest;
import pl.krzywyyy.animalshelter.model.entity.Animal;
import pl.krzywyyy.animalshelter.repository.AnimalRepository;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {AnimalRepository.class}
)
public interface AnimalMapper {
    @Mapping(target = "id", ignore = true)
    Animal requestToEntity(AnimalRequest animalRequest);
}
