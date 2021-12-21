package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.AddressMapper;
import pl.krzywyyy.animalshelter.model.dto.request.AddressRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AddressResponse;
import pl.krzywyyy.animalshelter.repository.AddressRepository;
import pl.krzywyyy.animalshelter.services.AddressService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse save(AddressRequest addressRequest) {
        return null;
    }

    @Override
    public AddressResponse findById(int id) {
        return null;
    }

    @Override
    public List<AddressResponse> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
