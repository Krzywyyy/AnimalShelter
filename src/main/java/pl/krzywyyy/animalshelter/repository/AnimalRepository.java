package pl.krzywyyy.animalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
