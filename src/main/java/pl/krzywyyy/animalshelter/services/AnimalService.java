package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.AnimalRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AnimalResponse;

import java.util.List;

public interface AnimalService {
    AnimalResponse save(AnimalRequest animalRequest);

    AnimalResponse findById(int id);

    List<AnimalResponse> findAll();

    boolean delete(int id);
}
