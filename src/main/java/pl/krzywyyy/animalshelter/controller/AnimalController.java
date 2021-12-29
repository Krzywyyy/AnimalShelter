package pl.krzywyyy.animalshelter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.krzywyyy.animalshelter.model.dto.request.AnimalRequest;
import pl.krzywyyy.animalshelter.model.dto.response.AnimalResponse;
import pl.krzywyyy.animalshelter.model.dto.update.AnimalUpdate;
import pl.krzywyyy.animalshelter.services.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponse save(@RequestBody AnimalRequest animalRequest) {
        return animalService.save(animalRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<AnimalResponse> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.FOUND)
    public AnimalResponse findById(@PathVariable int animalId) {
        return animalService.findById(animalId);
    }

    @PutMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@PathVariable int animalId, @RequestBody AnimalUpdate animalUpdate) {
        return animalService.update(animalId, animalUpdate);
    }

    @DeleteMapping("/{animalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int animalId) {
        animalService.delete(animalId);
    }
}
