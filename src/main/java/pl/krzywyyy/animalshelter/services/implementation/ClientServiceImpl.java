package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.ClientMapper;
import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.dto.response.ClientResponse;
import pl.krzywyyy.animalshelter.model.dto.update.ClientUpdate;
import pl.krzywyyy.animalshelter.repository.ClientRepository;
import pl.krzywyyy.animalshelter.services.ClientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponse save(ClientRequest clientRequest) {
        return null;
    }

    @Override
    public ClientResponse findById(int id) {
        return null;
    }

    @Override
    public List<ClientResponse> findAll() {
        return null;
    }

    @Override
    public ClientResponse update(int clientId, ClientUpdate clientUpdate) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
