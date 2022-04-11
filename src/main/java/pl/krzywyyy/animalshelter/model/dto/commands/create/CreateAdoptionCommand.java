package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class CreateAdoptionCommand {
    private Date adoptionDate;
    private int animalId;
    private int clientId;
    private int employeeId;
}
