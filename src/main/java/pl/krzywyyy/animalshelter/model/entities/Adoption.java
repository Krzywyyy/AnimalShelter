package pl.krzywyyy.animalshelter.model.entities;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entities.abstracts.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
@Setter
@Getter
public class Adoption extends AbstractEntity {
    @NotNull
    @PastOrPresent
    @Column(name = "adoption_date")
    private Date adoptionDate;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
