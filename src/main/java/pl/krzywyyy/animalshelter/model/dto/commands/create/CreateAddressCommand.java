package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class CreateAddressCommand {
    private final String streetName;
    private final String buildingNumber;
    private final String apartmentNumber;
    private final String postalCode;
    private final String city;
    private final int clientId;
}
