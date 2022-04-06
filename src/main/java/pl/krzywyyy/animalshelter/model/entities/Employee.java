package pl.krzywyyy.animalshelter.model.entities;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entities.abstracts.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Employee extends User {

    @NotNull
    @Column(name = "employment_date")
    @NotBlank(message = "Employment date cannot be empty")
    @PastOrPresent(message = "Employment date cannot be from future")
    private Date employmentDate;

    @Column(name = "end_date_of_work")
    @PastOrPresent(message = "End date of work cannot be from future")
    private Date endDateOfWork;

    @NotNull
    @Column(name = "job_position")
    @NotBlank(message = "Employee must have job position")
    private String jobPosition;

    @NotNull
    @Positive(message = "Salary must be positive")
    private float salary;

    @Column(name = "supervised_adoptions")
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Adoption> supervisedAdoptions;
}
