package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entities.Adoption;
import pl.krzywyyy.animalshelter.repositories.jpamapstructfix.ById;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {
    @ById
    @Override
    Adoption getById(Integer integer);
}
