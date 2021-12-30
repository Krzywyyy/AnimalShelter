package pl.krzywyyy.animalshelter.model.dto.update;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ClientUpdate {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
}
