package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.request.AddressRequest;
import pl.krzywyyy.animalshelter.model.entity.Address;
import pl.krzywyyy.animalshelter.repository.ClientRepository;
import pl.krzywyyy.animalshelter.repository.jpamapstructfix.ById;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = ClientRepository.class
)
public interface AddressMapper {
    @Mappings({
            @Mapping(source = "clientId", target = "client", qualifiedBy = ById.class),
            @Mapping(target = "id", ignore = true)
    })
    Address requestToEntity(AddressRequest addressRequest);
}
