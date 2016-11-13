package com.roisoftstudio.animalshelter.framework.repositories;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

import static com.roisoftstudio.animalshelter.domain.animal.AnimalBuilder.anAnimal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= RANDOM_PORT)
public class JdbcAnimalRepositoryTest {

    @Inject
    private AnimalRepository animalRepository;

    @Test
    public void should_return_always_animals() {
        List<Animal> animals = animalRepository.getAllAnimals();

        assertThat(animals).isNotEmpty();
    }

    @Test
    public void should_add_new_animal() {
        List<Animal> animalsBeforeAdd = animalRepository.getAllAnimals();
        animalsBeforeAdd.size();
        
        animalRepository.save(anAnimal(1, "testAnimal", "testDescription", "testType").createAnimal());

        List<Animal> animalsAfterAdd = animalRepository.getAllAnimals();
        assertThat(animalsAfterAdd.size()).isEqualTo(animalsBeforeAdd.size() + 1 );
    }

}