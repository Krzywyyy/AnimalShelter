package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entities.Client;
import pl.krzywyyy.animalshelter.repositories.jpamapstructfix.ById;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @ById
    default Client findClientById(Integer clientId) {
        return getById(clientId);
    }
}
