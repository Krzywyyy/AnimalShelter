package pl.krzywyyy.animalshelter.model.entity.abstracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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

    @Column(name = "phone_number")
    @Pattern(regexp = "^[\\d]{9}$", message = "Phone number must contains 9 digits")
    private String phoneNumber;

    @Email(message = "Email is not unique")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
