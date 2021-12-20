package pl.krzywyyy.animalshelter.model.entity;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entity.abstracts.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Setter
@Getter
public class Employee extends AbstractEntity {

    @Column(name = "employment_date")
    @NotBlank(message = "Employment date cannot be empty")
    @PastOrPresent(message = "Employment date cannot be from future")
    private Date employmentDate;

    @Column(name = "end_date_of_work")
    @PastOrPresent(message = "End date of work cannot be from future")
    private Date endDateOfWork;

    @NotNull
    @Positive(message = "Salary must be positive")
    private float salary;
}
