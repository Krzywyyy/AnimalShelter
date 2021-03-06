package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@RequiredArgsConstructor
public final class CreateAdoptionCommand {
    private final Date adoptionDate;
    private final int animalId;
    private final int clientId;
    private final int employeeId;
}
