package pl.krzywyyy.animalshelter.model.entity.abstracts;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entity.Address;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@Getter
@Setter
public abstract class User extends AbstractEntity {

    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @Email(message = "Email is not unique")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
