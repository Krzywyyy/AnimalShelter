package pl.krzywyyy.animalshelter.model.entity;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entity.abstracts.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Address extends AbstractEntity {

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "building_number")
    @NotBlank(message = "Building number cannot be empty")
    private String buildingNumber;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "postal_code")
    @NotBlank(message = "Postal code cannot be empty")
    @Pattern(regexp = "^\\d{2}-\\d{3}$")
    @Size(min = 6, max = 6, message = "Postal Code length must be 6")
    private String postalCode;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
}
