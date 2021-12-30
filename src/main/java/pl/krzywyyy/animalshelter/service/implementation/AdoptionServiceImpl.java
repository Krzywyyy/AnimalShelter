package pl.krzywyyy.animalshelter.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.AdoptionMapper;
import pl.krzywyyy.animalshelter.model.dto.request.AdoptionRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AdoptionResponse;
import pl.krzywyyy.animalshelter.repository.AdoptionRepository;
import pl.krzywyyy.animalshelter.service.AdoptionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final AdoptionMapper adoptionMapper;

    @Override
    public AdoptionResponse save(AdoptionRequest adoptionRequest) {
        return adoptionMapper.entityToResponse(
                adoptionRepository.save(
                        adoptionMapper.requestToEntity(adoptionRequest)
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
