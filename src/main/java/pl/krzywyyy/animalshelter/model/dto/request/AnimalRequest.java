package pl.krzywyyy.animalshelter.model.dto.request;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class AnimalRequest {
    private String name;
    private String type;
    private Date birthDate;
}
