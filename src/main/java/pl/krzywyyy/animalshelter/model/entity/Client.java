package pl.krzywyyy.animalshelter.model.entity;

import lombok.Getter;
import lombok.Setter;
import pl.krzywyyy.animalshelter.model.entity.abstracts.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Client extends User {

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Adoption> adoptions = new ArrayList<>();
}
