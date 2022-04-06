package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.CreateClientCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.ClientResponse;
import pl.krzywyyy.animalshelter.model.dto.updates.ClientUpdate;

import java.util.List;

public interface ClientService {
    ClientResponse save(CreateClientCommand createClientCommand);

    ClientResponse findById(int clientId);

    List<ClientResponse> findAll();

    ClientResponse update(int clientId, ClientUpdate clientUpdate);

    void delete(int clientId);
}
