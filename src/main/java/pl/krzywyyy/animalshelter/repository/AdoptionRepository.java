package pl.krzywyyy.animalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entity.Adoption;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {
}
