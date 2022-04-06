package pl.krzywyyy.animalshelter.model.entities.abstracts;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entities.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class User extends AbstractEntity {

    @NotNull
    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotNull
    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @Column(name = "phone_number")
    @Pattern(regexp = "^[\\d]{9}$", message = "Phone number must contains 9 digits")
    private String phoneNumber;

    @NotNull
    @Email(message = "Email is not valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;
}
