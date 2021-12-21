package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.dto.AddressRequest;
import pl.krzywyyy.animalshelter.model.entity.Address;
import pl.krzywyyy.animalshelter.repository.AddressRepository;
import pl.krzywyyy.animalshelter.repository.ClientRepository;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                AddressRepository.class,
                ClientRepository.class
        }
)
public interface AddressMapper {
    @Mappings({
            @Mapping(source = "clientId", target = "client"),
            @Mapping(target = "id", ignore = true)
    })
    Address requestToEntity(AddressRequest addressRequest);
}
