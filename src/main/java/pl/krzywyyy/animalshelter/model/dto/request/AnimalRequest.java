package pl.krzywyyy.animalshelter.model.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class AnimalRequest {
    private String name;
    private String type;
    private Date birthDate;
}
