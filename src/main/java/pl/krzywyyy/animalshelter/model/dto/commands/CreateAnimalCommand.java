package pl.krzywyyy.animalshelter.model.dto.commands;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class CreateAnimalCommand {
    private String name;
    private String type;
    private Date birthDate;
}
