package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateAddressCommand {
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;
    private int clientId;
}
