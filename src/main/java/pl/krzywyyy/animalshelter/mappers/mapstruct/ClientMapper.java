package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.mappers.PasswordMapper;
import pl.krzywyyy.animalshelter.mappers.annotations.PasswordEncoder;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateClientCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.ClientResponse;
import pl.krzywyyy.animalshelter.model.entities.Client;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                AbstractMapper.class,
                PasswordMapper.class
        }
)
public interface ClientMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roles", ignore = true),
            @Mapping(target = "addresses", ignore = true),
            @Mapping(target = "adoptions", ignore = true),
            @Mapping(target = "password", qualifiedBy = PasswordEncoder.class)
    })
    Client requestToEntity(CreateClientCommand createClientCommand);

    @Mappings({
            @Mapping(source = "addresses", target = "addressesIds"),
            @Mapping(source = "adoptions", target = "adoptionsIds")
    })
    ClientResponse entityToResponse(Client client);
}
