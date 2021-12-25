package pl.krzywyyy.animalshelter.model.dto.update;

import lombok.Getter;

@Getter
public class AddressUpdate {
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;
}
