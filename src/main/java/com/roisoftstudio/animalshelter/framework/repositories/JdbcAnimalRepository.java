package com.roisoftstudio.animalshelter.framework.repositories;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class JdbcAnimalRepository implements AnimalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Animal> getAllAnimals() {
        return jdbcTemplate.query("select * from animals", new AnimalRowMapper());
    }

    @Override
    public void save(Animal animal) {
        Object[] args = {animal.getName(),
                animal.getImageUrl(),
                animal.getDescription(),
                animal.getType(),
                animal.getBreed(),
                animal.getAge(),
                animal.getGender(),
                animal.getLocation(),
                animal.getOwnerId()};
        jdbcTemplate.update("INSERT INTO animals (name, imageUrl, description, type, breed, age, gender, location, ownerId) values (?, ?, ?, ?, ?, ?, ?, ?, ?)", args);
    }


}
