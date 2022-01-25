package pl.krzywyyy.animalshelter.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AnimalResponse {
    private String name;
    private String type;
    private Date birthDate;
    private int age;
    private int adoptionId;
}
