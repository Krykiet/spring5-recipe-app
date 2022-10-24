package com.krykiet.spring5recipeapp.repositories;

import com.krykiet.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    // Add that to find objects from database using findByDescription method - query methods
    Optional<UnitOfMeasure> findByDescription(String description);
}
