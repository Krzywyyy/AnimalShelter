package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public final class CreateClientCommand {
    private final String firstName;
    private final String surname;
    private final String phoneNumber;
    private final String email;
    private final String password;
}
