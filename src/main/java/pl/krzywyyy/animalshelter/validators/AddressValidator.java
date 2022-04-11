package pl.krzywyyy.animalshelter.validators;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pl.krzywyyy.animalshelter.exceptions.InvalidUpdateDataException;
import pl.krzywyyy.animalshelter.model.dto.commands.update.AddressUpdateCommand;

@Component
public class AddressValidator {
    @SneakyThrows
    public void validate(AddressUpdateCommand addressUpdateCommand) {
        if (addressUpdateCommand.getApartmentNumber() != null && addressUpdateCommand.getBuildingNumber() == null) {
            throw new InvalidUpdateDataException("Address cannot include apartment number if building number is not specified.");
        }
    }
}
