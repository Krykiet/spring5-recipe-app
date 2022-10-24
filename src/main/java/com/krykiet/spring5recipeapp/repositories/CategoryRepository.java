package com.krykiet.spring5recipeapp.repositories;

import com.krykiet.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    // Add that to find objects from database using findByDescription method - query methods
    Optional<Category> findByDescription(String description);
}
