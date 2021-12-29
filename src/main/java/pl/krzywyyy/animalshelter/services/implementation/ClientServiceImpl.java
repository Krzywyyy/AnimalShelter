package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.ClientMapper;
import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.dto.response.ClientResponse;
import pl.krzywyyy.animalshelter.model.dto.update.ClientUpdate;
import pl.krzywyyy.animalshelter.model.entity.Client;
import pl.krzywyyy.animalshelter.repository.ClientRepository;
import pl.krzywyyy.animalshelter.services.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponse save(ClientRequest clientRequest) {
        return clientMapper.entityToResponse(
                clientRepository.save(
                        clientMapper.requestToEntity(clientRequest)
                )
        );
    }

    @Override
    public ClientResponse findById(int clientId) {
        return clientMapper.entityToResponse(
                clientRepository.getById(clientId)
        );
    }

    @Override
    public List<ClientResponse> findAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse update(int clientId, ClientUpdate clientUpdate) {
        final Client client = clientRepository.getById(clientId);
        client.setFirstName(clientUpdate.getFirstName());
        client.setSurname(clientUpdate.getSurname());
        client.setPhoneNumber(clientUpdate.getPhoneNumber());
        client.setEmail(clientUpdate.getEmail());
        final Client updated = clientRepository.saveAndFlush(client);
        return clientMapper.entityToResponse(updated);
    }

    @Override
    public void delete(int clientId) {
        clientRepository.delete(
                clientRepository.getById(clientId)
        );
    }
}
