package pl.krzywyyy.animalshelter.service.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.AddressMapper;
import pl.krzywyyy.animalshelter.model.dto.request.AddressRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AddressResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AddressUpdate;
import pl.krzywyyy.animalshelter.model.entity.Address;
import pl.krzywyyy.animalshelter.repository.AddressRepository;
import pl.krzywyyy.animalshelter.service.AddressService;
import pl.krzywyyy.animalshelter.validator.AddressValidator;

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
    public AddressResponse save(AddressRequest addressRequest) {
        logger.debug(String.format("Saving address = [%s] to database", addressRequest.toString()));
        final Address newAddress = addressMapper.requestToEntity(addressRequest);
        final Address updated = addressRepository.save(newAddress);
        logger.debug(String.format("Address successfully created with id = [%s]", updated.getId()));
        return addressMapper.entityToResponse(updated);
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
    public AddressResponse update(int addressId, AddressUpdate addressUpdate) {
        addressValidator.validate(addressUpdate);

        final Address address = addressRepository.getById(addressId);
        address.setStreetName(addressUpdate.getStreetName());
        address.setBuildingNumber(addressUpdate.getBuildingNumber());
        address.setApartmentNumber(addressUpdate.getApartmentNumber());
        address.setPostalCode(addressUpdate.getPostalCode());
        address.setCity(addressUpdate.getCity());
        final Address updated = addressRepository.save(address);
        return addressMapper.entityToResponse(updated);
    }

    @Override
    public void delete(int addressId) {
        final Address address = addressRepository.getById(addressId);
        addressRepository.delete(address);
    }
}
