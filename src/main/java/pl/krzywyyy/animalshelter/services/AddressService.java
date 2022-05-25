package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAddressCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.AddressUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AddressResponse;

import java.util.List;

public interface AddressService {
    void save(CreateAddressCommand createAddressCommand);

    AddressResponse findById(int addressId);

    List<AddressResponse> findAll();

    void update(int addressId, AddressUpdateCommand addressUpdateCommand);

    void delete(int addressId);
}
