package pl.krzywyyy.animalshelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krzywyyy.animalshelter.model.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
