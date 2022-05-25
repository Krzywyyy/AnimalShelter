package pl.krzywyyy.animalshelter.model.entities;


import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entities.abstracts.AbstractEntity;
import pl.krzywyyy.animalshelter.model.enums.AnimalType;
import pl.krzywyyy.animalshelter.model.enums.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Animal extends AbstractEntity {

    @NotNull
    @NotBlank(message = "Animal must have a name")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Animal type must be specified")
    private AnimalType type;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @PastOrPresent
    @Column(name = "birth_date")
    private Date birthDate;

    @Transient
    @PositiveOrZero(message = "Age must be positive or zero")
    private int age;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private List<Disease> diseases;

    @OneToOne(mappedBy = "animal")
    private Adoption adoption;

    @PostLoad
    private void calculateAge() {
        if (birthDate == null) {
            return;
        }
        final LocalDate birthDateLocal = LocalDate.ofInstant(birthDate.toInstant(), ZoneId.systemDefault());
        this.age = Period.between(birthDateLocal, LocalDate.now()).getYears();
    }
}
