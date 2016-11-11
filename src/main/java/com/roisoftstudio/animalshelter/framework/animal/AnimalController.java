package com.roisoftstudio.animalshelter.framework.animal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import com.roisoftstudio.animalshelter.framework.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static com.roisoftstudio.animalshelter.domain.animal.AnimalBuilder.aPuppy;
import static java.util.Arrays.asList;

@RestController
public class AnimalController {

    private AnimalRepository animalRepository;

    @Inject
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping("/animals")
    public List<Animal> greeting() {
        return animalRepository.getAllAnimals();
    }


}