package com.krykiet.spring5recipeapp.services;

import com.krykiet.spring5recipeapp.commands.RecipeCommand;
import com.krykiet.spring5recipeapp.domain.Recipe;

import javax.transaction.Transactional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
