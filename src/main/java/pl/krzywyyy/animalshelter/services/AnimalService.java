package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.CreateAnimalCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AnimalResponse;
import pl.krzywyyy.animalshelter.model.dto.updates.AnimalUpdate;

import java.util.List;

public interface AnimalService {
    AnimalResponse save(CreateAnimalCommand createAnimalCommand);

    AnimalResponse findById(int animalId);

    List<AnimalResponse> findAll();

    AnimalResponse update(int animalId, AnimalUpdate animalUpdate);

    void delete(int animalId);
}
