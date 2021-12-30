package pl.krzywyyy.animalshelter.service.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.AnimalMapper;
import pl.krzywyyy.animalshelter.model.dto.request.AnimalRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AnimalResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AnimalUpdate;
import pl.krzywyyy.animalshelter.model.entity.Animal;
import pl.krzywyyy.animalshelter.repository.AnimalRepository;
import pl.krzywyyy.animalshelter.service.AnimalService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;
    private final Logger logger;

    @Override
    public AnimalResponse save(AnimalRequest animalRequest) {
        return animalMapper.entityToResponse(
                animalRepository.save(
                        animalMapper.requestToEntity(animalRequest)
                )
        );
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
    public AnimalResponse update(int animalId, AnimalUpdate animalUpdate) {
        final Animal animal = animalRepository.getById(animalId);
        animal.setName(animalUpdate.getName());
        final Animal updated = animalRepository.save(animal);
        return animalMapper.entityToResponse(updated);
    }

    @Override
    public void delete(int animalId) {
        animalRepository.delete(
                animalRepository.getById(animalId)
        );
    }
}
