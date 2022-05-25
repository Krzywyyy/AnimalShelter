package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entities.Address;
import pl.krzywyyy.animalshelter.repositories.jpamapstructfix.ById;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @ById
    @Override
    Address getById(Integer integer);
}
