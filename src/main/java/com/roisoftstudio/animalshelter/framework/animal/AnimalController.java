package com.roisoftstudio.animalshelter.framework.animal;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import com.roisoftstudio.animalshelter.framework.Responses.HttpResponse;
import com.roisoftstudio.animalshelter.framework.repositories.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AnimalController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimalController.class);

    private AnimalRepository animalRepository;

    @Inject
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "Animal Api is up!";
    }

    @RequestMapping(value = "/animals", produces = APPLICATION_JSON_VALUE)
    public List<Animal> greeting() {
        return animalRepository.getAllAnimals();
    }

    @RequestMapping(value="/animals/add", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpResponse add(@RequestBody Animal animal) {
        LOG.info("/animals/add - " + animal.getName());

        try {
            animalRepository.save(animal);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
        return new HttpResponse(OK.value(), "The animal was saved successfully");
    }
}