package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAddressCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AddressResponse;
import pl.krzywyyy.animalshelter.model.entities.Address;
import pl.krzywyyy.animalshelter.repositories.ClientRepository;
import pl.krzywyyy.animalshelter.repositories.jpamapstructfix.ById;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = ClientRepository.class
)
public interface AddressMapper {
    @Mappings({
            @Mapping(source = "clientId", target = "client", qualifiedBy = ById.class),
            @Mapping(target = "id", ignore = true)
    })
    Address requestToEntity(CreateAddressCommand createAddressCommand);

    AddressResponse entityToResponse(Address address);
}
