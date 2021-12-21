package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.dto.response.ClientResponse;

import java.util.List;

public interface ClientService {
    ClientResponse save(ClientRequest clientRequest);

    ClientResponse findById(int id);

    List<ClientResponse> findAll();

    boolean delete(int id);
}
