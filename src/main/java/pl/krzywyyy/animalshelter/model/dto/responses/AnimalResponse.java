package pl.krzywyyy.animalshelter.model.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalResponse {
    private String name;
    private String type;
    private String gender;
    private Date birthDate;
    private String diseases;
    private int age;
    private Integer adoptionId;
}
