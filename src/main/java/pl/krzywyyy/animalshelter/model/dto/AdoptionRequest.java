package pl.krzywyyy.animalshelter.model.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class AdoptionRequest {
    private Date date;
    private int animalId;
    private int clientId;
}
