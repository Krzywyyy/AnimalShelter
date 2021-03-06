package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mappers.mapstruct.AddressMapper;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAddressCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.AddressUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AddressResponse;
import pl.krzywyyy.animalshelter.model.entities.Address;
import pl.krzywyyy.animalshelter.repositories.AddressRepository;
import pl.krzywyyy.animalshelter.services.AddressService;
import pl.krzywyyy.animalshelter.validators.AddressValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final AddressValidator addressValidator;
    private final Logger logger;

    @Override
    public void save(CreateAddressCommand createAddressCommand) {
        logger.debug(String.format("Saving address = [%s] to database", createAddressCommand.toString()));
        final Address address = addressMapper.requestToEntity(createAddressCommand);
        addressRepository.save(address);
    }

    @Override
    public AddressResponse findById(int addressId) {
        logger.debug(String.format("Looking for address with id = [%s] in database", addressId));
        final Address address = addressRepository.getById(addressId);
        return addressMapper.entityToResponse(address);
    }

    @Override
    public List<AddressResponse> findAll() {
        final List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(addressMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void update(int addressId, AddressUpdateCommand addressUpdateCommand) {
        addressValidator.validate(addressUpdateCommand);

        final Address address = addressRepository.getById(addressId);
        address.setStreetName(addressUpdateCommand.getStreetName());
        address.setBuildingNumber(addressUpdateCommand.getBuildingNumber());
        address.setApartmentNumber(addressUpdateCommand.getApartmentNumber());
        address.setPostalCode(addressUpdateCommand.getPostalCode());
        address.setCity(addressUpdateCommand.getCity());
        addressRepository.save(address);
    }

    @Override
    public void delete(int addressId) {
        final Address address = addressRepository.getById(addressId);
        addressRepository.delete(address);
    }
}
