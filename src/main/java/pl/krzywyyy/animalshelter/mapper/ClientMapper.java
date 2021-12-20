package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.krzywyyy.animalshelter.model.dto.ClientRequest;
import pl.krzywyyy.animalshelter.model.entity.Client;
import pl.krzywyyy.animalshelter.repository.ClientRepository;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ClientRepository.class}
)
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    Client requestToEntity(ClientRequest clientRequest);
}
