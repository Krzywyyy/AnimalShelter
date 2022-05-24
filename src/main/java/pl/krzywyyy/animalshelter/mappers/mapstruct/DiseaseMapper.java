package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.entities.Disease;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface DiseaseMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "animal", ignore = true)
    })
    Disease fromName(String name);

    List<String> toNames(List<Disease> diseases);

    default String toName(Disease disease) {
        return disease.getName();
    }
}
