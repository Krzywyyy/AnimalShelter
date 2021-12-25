package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.AddressRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AddressResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AddressUpdate;

import java.util.List;

public interface AddressService {
    AddressResponse save(AddressRequest addressRequest);

    AddressResponse findById(int addressId);

    List<AddressResponse> findAll();

    AddressResponse update(int addressId, AddressUpdate addressUpdate);

    void delete(int addressId);
}
