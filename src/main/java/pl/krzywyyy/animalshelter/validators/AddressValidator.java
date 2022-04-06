package pl.krzywyyy.animalshelter.validators;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pl.krzywyyy.animalshelter.exceptions.InvalidUpdateDataException;
import pl.krzywyyy.animalshelter.model.dto.updates.AddressUpdate;

@Component
public class AddressValidator {
    @SneakyThrows
    public void validate(AddressUpdate addressUpdate) {
        if (addressUpdate.getApartmentNumber() != null && addressUpdate.getBuildingNumber() == null) {
            throw new InvalidUpdateDataException("Address cannot include apartment number if building number is not specified.");
        }
    }
}
