package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.AddressRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {
    AddressResponse save(AddressRequest addressRequest);

    AddressResponse findById(int id);

    List<AddressResponse> findAll();

    boolean delete(int id);
}
