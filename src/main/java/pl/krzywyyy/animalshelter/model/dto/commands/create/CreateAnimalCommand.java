package pl.krzywyyy.animalshelter.model.dto.commands.create;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@ToString
public class CreateAnimalCommand {
    private String name;
    private String type;
    private String gender;
    private Date birthDate;
    private List<String> diseases;
}
