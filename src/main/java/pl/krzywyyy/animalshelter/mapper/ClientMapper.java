package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.entity.Client;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ClientMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "addresses", ignore = true),
            @Mapping(target = "adoptions", ignore = true)
    })
    Client requestToEntity(ClientRequest clientRequest);
}
