package com.roisoftstudio.animalshelter.framework.animal;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import com.roisoftstudio.animalshelter.framework.repositories.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class AnimalController {

    private AnimalRepository animalRepository;

    @Inject
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "Animal Api is up!";
    }

    @RequestMapping("/animals")
    public List<Animal> greeting() {
        return animalRepository.getAllAnimals();
    }

    @RequestMapping(value="/animals/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody Animal animal) {
        animalRepository.save(animal);
    }
}