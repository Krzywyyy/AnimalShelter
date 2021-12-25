package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.request.AnimalRequest;
import pl.krzywyyy.animalshelter.model.entity.Animal;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AnimalMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "adoption", ignore = true)
    })
    Animal requestToEntity(AnimalRequest animalRequest);
}
