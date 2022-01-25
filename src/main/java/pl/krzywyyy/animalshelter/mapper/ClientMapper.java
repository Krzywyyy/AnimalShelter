package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.dto.response.ClientResponse;
import pl.krzywyyy.animalshelter.model.entity.Client;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = AbstractMapper.class
)
public interface ClientMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "addresses", ignore = true),
            @Mapping(target = "adoptions", ignore = true)
    })
    Client requestToEntity(ClientRequest clientRequest);

    @Mappings({
            @Mapping(source = "addresses", target = "addressesIds"),
            @Mapping(source = "adoptions", target = "adoptionsIds")
    }
    )
    ClientResponse entityToResponse(Client client);
}
