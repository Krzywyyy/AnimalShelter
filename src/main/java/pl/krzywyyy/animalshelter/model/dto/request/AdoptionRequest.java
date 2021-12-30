package pl.krzywyyy.animalshelter.model.dto.request;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class AdoptionRequest {
    private Date adoptionDate;
    private int animalId;
    private int clientId;
    private int employeeId;
}
