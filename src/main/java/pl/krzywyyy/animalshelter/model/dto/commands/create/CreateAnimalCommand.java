package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public final class CreateAnimalCommand {
    private final String name;
    private final String type;
    private final String gender;
    private final Date birthDate;
    private final List<String> diseases;
}
