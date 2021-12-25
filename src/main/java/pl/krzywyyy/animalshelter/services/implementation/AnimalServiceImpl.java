package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.AnimalMapper;
import pl.krzywyyy.animalshelter.model.dto.request.AnimalRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AnimalResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AnimalUpdate;
import pl.krzywyyy.animalshelter.repository.AnimalRepository;
import pl.krzywyyy.animalshelter.services.AnimalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalResponse save(AnimalRequest animalRequest) {
        return null;
    }

    @Override
    public AnimalResponse findById(int id) {
        return null;
    }

    @Override
    public List<AnimalResponse> findAll() {
        return null;
    }

    @Override
    public AnimalResponse update(int animalId, AnimalUpdate animalUpdate) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
