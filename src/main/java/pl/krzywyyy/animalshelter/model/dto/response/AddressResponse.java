package pl.krzywyyy.animalshelter.model.dto.response;

import lombok.Setter;

@Setter
public class AddressResponse {
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;
}
