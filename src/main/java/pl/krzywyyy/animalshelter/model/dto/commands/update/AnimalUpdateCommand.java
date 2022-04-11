package pl.krzywyyy.animalshelter.model.dto.commands.update;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AnimalUpdateCommand {
    private String name;
    private List<String> diseases;
}
