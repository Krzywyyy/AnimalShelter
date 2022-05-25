package pl.krzywyyy.animalshelter.testing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.krzywyyy.animalshelter.mappers.mapstruct.AddressMapper;
import pl.krzywyyy.animalshelter.mappers.mapstruct.AdoptionMapper;
import pl.krzywyyy.animalshelter.mappers.mapstruct.AnimalMapper;
import pl.krzywyyy.animalshelter.mappers.mapstruct.ClientMapper;
import pl.krzywyyy.animalshelter.mappers.mapstruct.EmployeeMapper;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAdoptionCommand;
import pl.krzywyyy.animalshelter.model.entities.Adoption;
import pl.krzywyyy.animalshelter.repositories.AddressRepository;
import pl.krzywyyy.animalshelter.repositories.AdoptionRepository;
import pl.krzywyyy.animalshelter.repositories.AnimalRepository;
import pl.krzywyyy.animalshelter.repositories.ClientRepository;
import pl.krzywyyy.animalshelter.repositories.EmployeeRepository;
import pl.krzywyyy.animalshelter.repositories.RoleRepository;
import pl.krzywyyy.animalshelter.security.roles.SecurityRole;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class DbData {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final AdoptionRepository adoptionRepository;
    private final AdoptionMapper adoptionMapper;
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void populateDb() {
        addClients();
        addEmployees();
        addClientAddresses();
        addAnimals();
        addAdoptions();

        System.out.println();
    }

    private void addAdoptions() {
        for (CreateAdoptionCommand cmd : TestData.adoptions) {
            final Adoption adoption = new Adoption();
            adoption.setAnimal(animalRepository.getById(cmd.getAnimalId()));
            adoption.setClient(clientRepository.getById(cmd.getClientId()));
            adoption.setEmployee(employeeRepository.getById(cmd.getEmployeeId()));
            adoption.setAdoptionDate(cmd.getAdoptionDate());
            adoptionRepository.save(adoption);
        }
    }

    private void addAnimals() {
        TestData.animals.stream()
                .map(animalMapper::requestToEntity)
                .forEach(animalRepository::save);
    }

    private void addClientAddresses() {
        TestData.addresses.stream()
                .map(addressMapper::requestToEntity)
                .forEach(addressRepository::save);
    }

    @Transactional
    private void addEmployees() {
        TestData.employees.stream()
                .map(employeeMapper::requestToEntity)
                .peek(employee -> employee.setRoles(List.of(roleRepository.findByName(SecurityRole.ROLE_EMPLOYEE.name()))))
                .forEach(employeeRepository::save);
    }

    @Transactional
    private void addClients() {
        TestData.clients.stream()
                .map(clientMapper::requestToEntity)
                .peek(client -> client.setRoles(List.of(roleRepository.findByName(SecurityRole.ROLE_CLIENT.name()))))
                .forEach(clientRepository::save);
    }
}
