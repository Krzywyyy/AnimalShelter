package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAnimalCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.update.AnimalUpdateCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AnimalResponse;

import java.util.List;

public interface AnimalService {
    void save(CreateAnimalCommand createAnimalCommand);

    AnimalResponse findById(int animalId);

    List<AnimalResponse> findAll();

    void update(int animalId, AnimalUpdateCommand animalUpdateCommand);

    void delete(int animalId);
}
