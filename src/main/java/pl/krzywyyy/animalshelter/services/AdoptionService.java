package pl.krzywyyy.animalshelter.services;

import pl.krzywyyy.animalshelter.model.dto.request.AdoptionRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AdoptionResponse;

import java.util.List;

public interface AdoptionService {
    AdoptionResponse save(AdoptionRequest adoptionRequest);

    AdoptionResponse findById(int adoptionId);

    List<AdoptionResponse> findAll();

    boolean delete(int adoptionId);
}
