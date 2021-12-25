package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.dto.response.ClientResponse;
import pl.krzywyyy.animalshelter.model.dto.update.ClientUpdate;

import java.util.List;

public interface ClientService {
    ClientResponse save(ClientRequest clientRequest);

    ClientResponse findById(int id);

    List<ClientResponse> findAll();

    ClientResponse update(int clientId, ClientUpdate clientUpdate);

    boolean delete(int id);
}
