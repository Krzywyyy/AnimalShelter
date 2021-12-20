package pl.krzywyyy.animalshelter.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.krzywyyy.animalshelter.model.entity.Address;
import pl.krzywyyy.animalshelter.repository.AddressRepository;
import pl.krzywyyy.animalshelter.repository.ClientRepository;
import pl.krzywyyy.animalshelter.repository.EmployeeRepository;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                AddressRepository.class,
                ClientRepository.class,
                EmployeeRepository.class
        }
)
public interface AddressMapper {
    @Mappings({
            @Mapping(source = "userId", target = "user"),//TODO HOW??????????????
            @Mapping(target = "id", ignore = true)
    })
    Address requestToEntity(AddressRepository addressRepository);
}
