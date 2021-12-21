package pl.krzywyyy.animalshelter.model.dto.response;

import lombok.Setter;

@Setter
public class AnimalResponse {
    private String name;
    private String animalType;
    private int age;
    private int adoptionId;
}
