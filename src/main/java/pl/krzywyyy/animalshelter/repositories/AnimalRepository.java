package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entities.Animal;
import pl.krzywyyy.animalshelter.repositories.jpamapstructfix.ById;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @ById
    @Override
    Animal getById(Integer integer);
}
