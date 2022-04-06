package pl.krzywyyy.animalshelter.model.dto.updates;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressUpdate {
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;
}
