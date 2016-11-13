package com.roisoftstudio.animalshelter.framework.services;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import com.roisoftstudio.animalshelter.framework.exceptions.InvalidAnimalException;
import com.roisoftstudio.animalshelter.framework.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    @Inject
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.getAllAnimals();
    }

    public void save(Animal animal) throws InvalidAnimalException {
        validate(animal);
        animalRepository.save(animal);
    }

    private void validate(Animal animal) throws InvalidAnimalException {
        String errorMessage = "";
        if (isEmpty(animal.getOwnerId())) {
            errorMessage += "Mandatory attribute 'ownerId' is missing.\n";
        }
        if (isEmpty(animal.getName())) {
            errorMessage += "Mandatory attribute 'name' is missing.\n";
        }
        if (isEmpty(animal.getDescription())) {
            errorMessage += "Mandatory attribute 'description' is missing.\n";
        }
        if (isEmpty(animal.getType())) {
            errorMessage += "Mandatory attribute 'type' is missing.\n";
        }

        if (!isEmpty(errorMessage)) {
            throw new InvalidAnimalException("Animal is not valid: " + errorMessage);
        }
    }
}
