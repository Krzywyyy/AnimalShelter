package pl.krzywyyy.animalshelter.model.dto.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AdoptionResponse {
    private Date date;
    private int animalId;
    private int clientId;
    private int employeeId;
}
