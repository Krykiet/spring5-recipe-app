package com.krykiet.spring5recipeapp.services;

import com.krykiet.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
