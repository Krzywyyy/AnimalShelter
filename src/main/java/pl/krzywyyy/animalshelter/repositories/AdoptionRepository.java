package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entities.Adoption;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {
}
