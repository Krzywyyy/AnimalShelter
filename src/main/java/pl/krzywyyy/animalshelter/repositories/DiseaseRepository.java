package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzywyyy.animalshelter.model.entities.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {
}
