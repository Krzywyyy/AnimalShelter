package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAnimalCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AnimalResponse;
import pl.krzywyyy.animalshelter.model.entities.Animal;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                DiseaseMapper.class
        }
)
public interface AnimalMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "age", ignore = true),
            @Mapping(target = "adoption", ignore = true)
    })
    Animal requestToEntity(CreateAnimalCommand createAnimalCommand);

    @Mappings({
            @Mapping(source = "adoption.id", target = "adoptionId")
    })
    AnimalResponse entityToResponse(Animal animal);
}
