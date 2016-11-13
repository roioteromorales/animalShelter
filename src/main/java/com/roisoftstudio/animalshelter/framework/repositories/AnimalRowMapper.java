package com.roisoftstudio.animalshelter.framework.repositories;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.roisoftstudio.animalshelter.domain.animal.AnimalBuilder.anAnimal;

public class AnimalRowMapper implements RowMapper<Animal> {
    @Override
    public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Animal animal = anAnimal(rs.getInt("ownerId"), rs.getString("name"), rs.getString("description"), rs.getString("type"))
                .withImageUrl(rs.getString("imageUrl"))
                .withBreed(rs.getString("breed"))
                .withAge(rs.getString("age"))
                .withGender(rs.getString("gender"))
                .withLocation(rs.getString("location")).createAnimal();
        animal.setId(rs.getInt("id"));
        return animal;
    }
}