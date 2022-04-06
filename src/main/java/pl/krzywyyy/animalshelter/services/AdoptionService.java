package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.commands.CreateAdoptionCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AdoptionResponse;

import java.util.List;

public interface AdoptionService {
    AdoptionResponse save(CreateAdoptionCommand createAdoptionCommand);

    AdoptionResponse findById(int adoptionId);

    List<AdoptionResponse> findAll();

    void delete(int adoptionId);
}
