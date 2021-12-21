package pl.krzywyyy.animalshelter.model.dto.request;

import lombok.Getter;

@Getter
public class AddressRequest {
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;
    private int clientId;
}
