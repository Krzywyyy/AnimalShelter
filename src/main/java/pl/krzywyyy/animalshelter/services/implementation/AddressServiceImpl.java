package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.AddressMapper;
import pl.krzywyyy.animalshelter.model.dto.request.AddressRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AddressResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AddressUpdate;
import pl.krzywyyy.animalshelter.model.entity.Address;
import pl.krzywyyy.animalshelter.repository.AddressRepository;
import pl.krzywyyy.animalshelter.services.AddressService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse save(AddressRequest addressRequest) {
        return addressMapper.entityToResponse(
                addressRepository.save(
                        addressMapper.requestToEntity(addressRequest)
                )
        );
    }

    @Override
    public AddressResponse findById(int addressId) {
        return addressMapper.entityToResponse(
                addressRepository.getById(addressId)
        );
    }

    @Override
    public List<AddressResponse> findAll() {
        return addressRepository.findAll().stream()
                .map(addressMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse update(int addressId, AddressUpdate addressUpdate) {
        final Address address = addressRepository.getById(addressId);
        address.setStreetName(addressUpdate.getStreetName());
        address.setBuildingNumber(addressUpdate.getBuildingNumber());
        address.setApartmentNumber(addressUpdate.getApartmentNumber());
        address.setPostalCode(addressUpdate.getPostalCode());
        address.setCity(addressUpdate.getCity());
        final Address updated = addressRepository.saveAndFlush(address);
        return addressMapper.entityToResponse(updated);
    }

    @Override
    public void delete(int addressId) {
        addressRepository.delete(
                addressRepository.getById(addressId)
        );
    }
}
