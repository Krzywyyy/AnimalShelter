package pl.krzywyyy.animalshelter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krzywyyy.animalshelter.services.AdoptionService;

@RestController
@RequestMapping("/adoptions")
@RequiredArgsConstructor
public class AdoptionController {
    private final AdoptionService adoptionService;
}
