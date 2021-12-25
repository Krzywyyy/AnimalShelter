package pl.krzywyyy.animalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entity.Client;
import pl.krzywyyy.animalshelter.repository.jpamapstructfix.ById;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @ById
    default Client findClientById(Integer clientId) {
        return getById(clientId);
    }
}
