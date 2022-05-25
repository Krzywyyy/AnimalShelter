package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mappers.mapstruct.AnimalMapper;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAnimalCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.AnimalUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AnimalResponse;
import pl.krzywyyy.animalshelter.model.entities.Animal;
import pl.krzywyyy.animalshelter.repositories.AnimalRepository;
import pl.krzywyyy.animalshelter.services.AnimalService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;
    private final Logger logger;

    @Override
    public void save(CreateAnimalCommand createAnimalCommand) {
        logger.debug(String.format("Saving animal = [%s] to database", createAnimalCommand.toString()));
        final Animal animal = animalMapper.requestToEntity(createAnimalCommand);
        animalRepository.save(animal);
    }

    @Override
    public AnimalResponse findById(int animalId) {
        return animalMapper.entityToResponse(
                animalRepository.getById(animalId)
        );
    }

    @Override
    public List<AnimalResponse> findAll() {
        return animalRepository.findAll().stream()
                .map(animalMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void update(int animalId, AnimalUpdateCommand animalUpdateCommand) {
        final Animal animal = animalRepository.getById(animalId);
        animal.setName(animalUpdateCommand.getName());
        animalRepository.save(animal);
    }

    @Override
    public void delete(int animalId) {
        animalRepository.delete(
                animalRepository.getById(animalId)
        );
    }
}
