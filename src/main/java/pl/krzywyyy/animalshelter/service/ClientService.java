package pl.krzywyyy.animalshelter.service;

import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.dto.response.ClientResponse;
import pl.krzywyyy.animalshelter.model.dto.update.ClientUpdate;

import java.util.List;

public interface ClientService {
    ClientResponse save(ClientRequest clientRequest);

    ClientResponse findById(int clientId);

    List<ClientResponse> findAll();

    ClientResponse update(int clientId, ClientUpdate clientUpdate);

    void delete(int clientId);
}
