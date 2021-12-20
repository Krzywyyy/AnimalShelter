package pl.krzywyyy.animalshelter.model.entity;


import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entity.abstracts.AbstractEntity;
import pl.krzywyyy.animalshelter.model.enums.AnimalType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Setter
@Getter
public class Animal extends AbstractEntity {

    @NotBlank(message = "Animal must have a name")
    private String name;

    @PositiveOrZero(message = "Age must be positive or zero")
    private int age;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Animal type must be specified")
    private AnimalType type;

    @OneToOne
    @JoinColumn(name = "adoption_id", referencedColumnName = "id")
    private Adoption adoption;
}
