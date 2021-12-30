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
import pl.krzywyyy.animalshelter.model.dto.request.AddressRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AddressResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AddressUpdate;
import pl.krzywyyy.animalshelter.services.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final Logger logger;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse save(@RequestBody AddressRequest addressRequest) {
        logger.debug(String.format("[HTTP_POST]: Create new address = [%s]", addressRequest.toString()));
        return addressService.save(addressRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<AddressResponse> findAll() {
        logger.debug("[HTTP_GET]: Listing all addresses");
        return addressService.findAll();
    }

    @GetMapping("/{addressId}")
    @ResponseStatus(HttpStatus.FOUND)
    public AddressResponse findById(@PathVariable int addressId) {
        logger.debug(String.format("[HTTP_GET]: Find address with id = [%s]", addressId));
        return addressService.findById(addressId);
    }

    @PutMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse update(@PathVariable int addressId, @RequestBody AddressUpdate addressUpdate) {
        logger.debug(String.format("[HTTP_PUT]: Updating address with id = [%s], new values = [%s]", addressId, addressUpdate.toString()));
        return addressService.update(addressId, addressUpdate);
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int addressId) {
        logger.debug(String.format("[HTTP_DELETE]: Deleting address with id = [%s]", addressId));
        addressService.delete(addressId);
    }
}
