package pl.krzywyyy.animalshelter.model.dto.response;

import lombok.Setter;

import java.util.Date;

@Setter
public class AdoptionResponse {
    private Date date;
    private int animalId;
    private int clientId;
    private int employeeId;
}
