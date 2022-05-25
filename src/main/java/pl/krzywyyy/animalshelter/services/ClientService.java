package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateClientCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.ClientUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.ClientResponse;

import java.util.List;

public interface ClientService {
    void save(CreateClientCommand createClientCommand);

    ClientResponse findById(int clientId);

    List<ClientResponse> findAll();

    void update(int clientId, ClientUpdateCommand clientUpdateCommand);

    void delete(int clientId);
}
