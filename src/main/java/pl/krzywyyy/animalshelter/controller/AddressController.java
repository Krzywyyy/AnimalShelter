package pl.krzywyyy.animalshelter.controller;

import lombok.RequiredArgsConstructor;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse save(@RequestBody AddressRequest addressRequest) {
        return addressService.save(addressRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<AddressResponse> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{addressId}")
    @ResponseStatus(HttpStatus.FOUND)
    public AddressResponse findById(@PathVariable int addressId) {
        return addressService.findById(addressId);
    }

    @PutMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse update(@PathVariable int addressId, @RequestBody AddressUpdate addressUpdate) {
        return addressService.update(addressId, addressUpdate);
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int addressId) {
        addressService.delete(addressId);
    }
}
