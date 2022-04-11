package pl.krzywyyy.animalshelter.controllers;

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
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateClientCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.ClientUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.ClientResponse;
import pl.krzywyyy.animalshelter.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final Logger logger;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse save(@RequestBody CreateClientCommand createClientCommand) {
        logger.debug(String.format("[HTTP_POST]: Create new client = [%s]", createClientCommand.toString()));
        return clientService.save(createClientCommand);
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
    public ClientResponse update(@PathVariable int clientId, @RequestBody ClientUpdateCommand clientUpdateCommand) {
        logger.debug(String.format("[HTTP_PUT]: Updating client with id = [%s], new values = [%s]", clientId, clientUpdateCommand.toString()));
        return clientService.update(clientId, clientUpdateCommand);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int clientId) {
        logger.debug(String.format("[HTTP_DELETE]: Deleting client with id = [%s]", clientId));
        clientService.delete(clientId);
    }
}
