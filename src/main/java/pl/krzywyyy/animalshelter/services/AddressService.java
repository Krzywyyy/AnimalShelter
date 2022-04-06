package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.CreateAddressCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AddressResponse;
import pl.krzywyyy.animalshelter.model.dto.updates.AddressUpdate;

import java.util.List;

public interface AddressService {
    AddressResponse save(CreateAddressCommand createAddressCommand);

    AddressResponse findById(int addressId);

    List<AddressResponse> findAll();

    AddressResponse update(int addressId, AddressUpdate addressUpdate);

    void delete(int addressId);
}
