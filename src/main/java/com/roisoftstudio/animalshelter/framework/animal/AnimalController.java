package com.roisoftstudio.animalshelter.framework.animal;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import com.roisoftstudio.animalshelter.framework.Responses.HttpResponse;
import com.roisoftstudio.animalshelter.framework.exceptions.InvalidAnimalException;
import com.roisoftstudio.animalshelter.framework.repositories.AnimalRepository;
import com.roisoftstudio.animalshelter.framework.services.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AnimalController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimalController.class);

    private AnimalService animalService;

    @Inject
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping("/")
    public String home() {
        return "Animal Api is up!";
    }

    @RequestMapping(value = "/animals", produces = APPLICATION_JSON_VALUE)
    public List<Animal> greeting() {
        return animalService.getAllAnimals();
    }

    @RequestMapping(value="/animals/add", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpResponse add(@RequestBody Animal animal) {
        LOG.info("/animals/add - " + animal.getName());

        try {
            animalService.save(animal);
        } catch (InvalidAnimalException e) {
            LOG.error("Error adding animal " + animal.getName() + " - " + e.getMessage());
            return new HttpResponse(INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
        LOG.info("Successfully added - " + animal.getName());
        return new HttpResponse(OK.value(), "The animal was saved successfully");
    }
}