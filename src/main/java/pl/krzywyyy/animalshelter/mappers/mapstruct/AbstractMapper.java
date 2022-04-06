package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.krzywyyy.animalshelter.model.entities.abstracts.AbstractEntity;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AbstractMapper {
    default List<Integer> toIds(List<? extends AbstractEntity> aes) {
        return aes.stream()
                .map(AbstractEntity::getId)
                .collect(Collectors.toList());
    }
}
