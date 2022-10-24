package com.krykiet.spring5recipeapp.repositories;

import com.krykiet.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
