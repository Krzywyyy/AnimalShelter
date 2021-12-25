package pl.krzywyyy.animalshelter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.krzywyyy.animalshelter.model.dto.request.AdoptionRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AdoptionResponse;
import pl.krzywyyy.animalshelter.services.AdoptionService;

import java.util.List;

@RestController
@RequestMapping("/adoptions")
@RequiredArgsConstructor
public class AdoptionController {
    private final AdoptionService adoptionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdoptionResponse save(@RequestBody AdoptionRequest adoptionRequest) {
        return adoptionService.save(adoptionRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<AdoptionResponse> getAll() {
        return adoptionService.findAll();
    }

    @GetMapping("/{adoptionId}")
    @ResponseStatus(HttpStatus.FOUND)
    public AdoptionResponse getOne(@PathVariable int adoptionId) {
        return adoptionService.findById(adoptionId);
    }

    @DeleteMapping("/{adoptionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int adoptionId) {
        adoptionService.delete(adoptionId);
    }
}
