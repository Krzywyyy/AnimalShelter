package pl.krzywyyy.animalshelter.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import pl.krzywyyy.animalshelter.model.entities.abstracts.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Disease extends AbstractEntity {

    @NotNull
    @NotBlank
    @Length(max = 255)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
