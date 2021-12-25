package pl.krzywyyy.animalshelter.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.AdoptionMapper;
import pl.krzywyyy.animalshelter.model.dto.request.AdoptionRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AdoptionResponse;
import pl.krzywyyy.animalshelter.repository.AdoptionRepository;
import pl.krzywyyy.animalshelter.services.AdoptionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final AdoptionMapper adoptionMapper;

    @Override
    public AdoptionResponse save(AdoptionRequest adoptionRequest) {
        return null;
    }

    @Override
    public AdoptionResponse findById(int adoptionId) {
        return null;
    }

    @Override
    public List<AdoptionResponse> findAll() {
        return null;
    }

    @Override
    public boolean delete(int adoptionId) {
        return false;
    }
}
