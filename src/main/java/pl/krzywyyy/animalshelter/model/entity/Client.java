package pl.krzywyyy.animalshelter.model.entity;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entity.abstracts.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
public class Client extends User {

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Adoption> adoptions;
}
