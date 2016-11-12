package com.roisoftstudio.animalshelter.framework.animal;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import com.roisoftstudio.animalshelter.framework.repositories.AnimalRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import java.util.List;

import static org.springframework.http.MediaType.*;

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

    @RequestMapping(value="/animals/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void add(@RequestBody Animal animal) {
        animalRepository.save(animal);
    }
}