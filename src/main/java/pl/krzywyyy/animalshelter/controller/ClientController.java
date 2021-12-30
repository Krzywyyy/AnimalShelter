package pl.krzywyyy.animalshelter.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.krzywyyy.animalshelter.model.dto.request.ClientRequest;
import pl.krzywyyy.animalshelter.model.dto.response.ClientResponse;
import pl.krzywyyy.animalshelter.model.dto.update.ClientUpdate;
import pl.krzywyyy.animalshelter.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final Logger logger;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse save(@RequestBody ClientRequest clientRequest) {
        logger.debug(String.format("[HTTP_POST]: Create new client = [%s]", clientRequest.toString()));
        return clientService.save(clientRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ClientResponse> findAll() {
        logger.debug("[HTTP_GET]: Listing all clients");
        return clientService.findAll();
    }

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ClientResponse findById(@PathVariable int clientId) {
        logger.debug(String.format("[HTTP_GET]: Find client with id = [%s]", clientId));
        return clientService.findById(clientId);
    }

    @PutMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse update(@PathVariable int clientId, @RequestBody ClientUpdate clientUpdate) {
        logger.debug(String.format("[HTTP_PUT]: Updating client with id = [%s], new values = [%s]", clientId, clientUpdate.toString()));
        return clientService.update(clientId, clientUpdate);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int clientId) {
        logger.debug(String.format("[HTTP_DELETE]: Deleting client with id = [%s]", clientId));
        clientService.delete(clientId);
    }
}
