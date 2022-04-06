package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mappers.mapstruct.AdoptionMapper;
import pl.krzywyyy.animalshelter.model.dto.commands.CreateAdoptionCommand;
import pl.krzywyyy.animalshelter.model.dto.responses.AdoptionResponse;
import pl.krzywyyy.animalshelter.repositories.AdoptionRepository;
import pl.krzywyyy.animalshelter.services.AdoptionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final AdoptionMapper adoptionMapper;
    private final Logger logger;

    @Override
    public AdoptionResponse save(CreateAdoptionCommand createAdoptionCommand) {
        return adoptionMapper.entityToResponse(
                adoptionRepository.save(
                        adoptionMapper.requestToEntity(createAdoptionCommand)
                )
        );
    }

    @Override
    public AdoptionResponse findById(int adoptionId) {
        return adoptionMapper.entityToResponse(
                adoptionRepository.getById(adoptionId)
        );
    }

    @Override
    public List<AdoptionResponse> findAll() {
        return adoptionRepository.findAll().stream()
                .map(adoptionMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int adoptionId) {
        adoptionRepository.delete(
                adoptionRepository.getById(adoptionId)
        );
    }
}
