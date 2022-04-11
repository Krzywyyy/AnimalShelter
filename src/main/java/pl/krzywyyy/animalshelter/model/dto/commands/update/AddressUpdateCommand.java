package pl.krzywyyy.animalshelter.model.dto.commands.update;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressUpdateCommand {
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;
}
