package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
