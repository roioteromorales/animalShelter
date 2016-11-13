package com.roisoftstudio.animalshelter.framework.services;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import com.roisoftstudio.animalshelter.framework.exceptions.InvalidAnimalException;
import com.roisoftstudio.animalshelter.framework.repositories.AnimalRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;


public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test(expected = InvalidAnimalException.class)
    public void should_throwAnException_whenSavingAnAnimalWithoutName() throws Exception {
        animalService.save(new Animal(1, "", "description", "type"));
    }

    @Test(expected = InvalidAnimalException.class)
    public void should_throwAnException_whenSavingAnAnimalWithoutDescription() throws Exception {
        animalService.save(new Animal(1, "name", "", "type"));
    }

    @Test(expected = InvalidAnimalException.class)
    public void should_throwAnException_whenSavingAnAnimalWithoutType() throws Exception {
        animalService.save(new Animal(1, "name", "description", ""));
    }

    @Test
    public void should_saveAnAnimal_whenIsValid() throws Exception {
        Animal animal = new Animal(1, "name", "description", "type");
        animalService.save(animal);

        verify(animalRepository, only()).save(animal);
    }
}