package com.roisoftstudio.animalshelter.framework.repositories;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.roisoftstudio.animalshelter.domain.animal.AnimalBuilder.aPuppy;

@Service
public class InMemoryAnimalRepository implements AnimalRepository {
    private final List<Animal> animals;
    private String hipsterPuppy = "https://s-media-cache-ak0.pinimg.com/736x/6d/57/fc/6d57fc88efdf5286ef844aca8578712e.jpg";
    private String cutePuppy = "http://ghk.h-cdn.co/assets/16/09/980x490/landscape-1457107485-gettyimages-512366437.jpg";
    private String gangstaPuppy = "http://4.bp.blogspot.com/-m4scO7-J43k/T9wfjsg26VI/AAAAAAAACWY/dU4j5VM5u9A/s1600/Funny-Gangster-Puppy-2.jpg";
    private String smartPuppy = "http://4.bp.blogspot.com/-GcMVyqd8b-g/Tbos88UAC_I/AAAAAAAAAVA/Twcsj2TfjcQ/s1600/4899369_VoTVqD3s_c.jpg";
    private String waterPuppy = "http://www.pupsor.com/wp-content/uploads/2016/03/water-puppy.jpg";
    private String swimmerPuppy = "http://petapixel.com/assets/uploads/2014/09/COREY_promo.jpg";

    public InMemoryAnimalRepository() {
        animals = Arrays.asList(
                aPuppy().withName("Hipster Puppy").withImageUrl(hipsterPuppy).withDescription("hipsterPuppy description").createPuppy(),
                aPuppy().withName("Cute Puppy").withImageUrl(cutePuppy).withDescription("cutePuppy description").createPuppy(),
                aPuppy().withName("Gangsta Puppy").withImageUrl(gangstaPuppy).withDescription("gangstaPuppy description").createPuppy(),
                aPuppy().withName("Smart Puppy").withImageUrl(smartPuppy).withDescription("smartPuppy description").createPuppy(),
                aPuppy().withName("Water Puppy").withImageUrl(waterPuppy).withDescription("waterPuppy description").createPuppy(),
                aPuppy().withName("Swimmer Puppy").withImageUrl(swimmerPuppy).withDescription("swimmerPuppy description").createPuppy()
        );
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animals;
    }

    @Override
    public void save(Animal animal) {
        animals.add(animal);
    }
}
