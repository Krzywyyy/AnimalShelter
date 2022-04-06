package pl.krzywyyy.animalshelter.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import pl.krzywyyy.animalshelter.model.entities.abstracts.AbstractEntity;
import pl.krzywyyy.animalshelter.model.entities.abstracts.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
public class Role extends AbstractEntity {

    @NotNull
    @NotBlank
    @Length(min = 6, max = 255)
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
