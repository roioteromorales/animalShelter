package com.roisoftstudio.animalshelter.framework.repositories;

import com.roisoftstudio.animalshelter.domain.animal.Animal;

import java.util.List;

public interface AnimalRepository {
    List<Animal> getAllAnimals();
}
