package pl.krzywyyy.animalshelter.model.dto.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientResponse {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
    private List<Integer> addressesIds;
    private List<Integer> adoptionsIds;
}
