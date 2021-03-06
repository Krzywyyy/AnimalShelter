package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mappers.mapstruct.ClientMapper;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateClientCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.ClientUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.ClientResponse;
import pl.krzywyyy.animalshelter.model.entities.Client;
import pl.krzywyyy.animalshelter.repositories.ClientRepository;
import pl.krzywyyy.animalshelter.repositories.RoleRepository;
import pl.krzywyyy.animalshelter.security.roles.SecurityRole;
import pl.krzywyyy.animalshelter.services.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    private final ClientMapper clientMapper;
    private final Logger logger;

    @Override
    public void save(CreateClientCommand createClientCommand) {
        logger.debug(String.format("Saving client = [%s] to database", createClientCommand.toString()));
        final Client client = clientMapper.requestToEntity(createClientCommand);
        client.setRoles(List.of(roleRepository.findByName(SecurityRole.ROLE_CLIENT.name())));
        clientRepository.save(client);
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
    public void update(int clientId, ClientUpdateCommand clientUpdateCommand) {
        final Client client = clientRepository.getById(clientId);
        client.setFirstName(clientUpdateCommand.getFirstName());
        client.setSurname(clientUpdateCommand.getSurname());
        client.setPhoneNumber(clientUpdateCommand.getPhoneNumber());
        client.setEmail(clientUpdateCommand.getEmail());
        clientRepository.save(client);
    }

    @Override
    public void delete(int clientId) {
        clientRepository.delete(
                clientRepository.getById(clientId)
        );
    }
}
