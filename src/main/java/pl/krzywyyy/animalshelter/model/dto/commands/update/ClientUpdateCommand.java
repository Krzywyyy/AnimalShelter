package pl.krzywyyy.animalshelter.model.dto.commands.update;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ClientUpdateCommand {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
}
