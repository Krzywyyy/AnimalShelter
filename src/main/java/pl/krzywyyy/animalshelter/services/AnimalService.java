package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.AnimalRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AnimalResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AnimalUpdate;

import java.util.List;

public interface AnimalService {
    AnimalResponse save(AnimalRequest animalRequest);

    AnimalResponse findById(int id);

    List<AnimalResponse> findAll();

    AnimalResponse update(int animalId, AnimalUpdate animalUpdate);

    boolean delete(int id);
}
