package com.krykiet.spring5recipeapp.services;

import com.krykiet.spring5recipeapp.commands.IngredientCommand;
import com.krykiet.spring5recipeapp.converters.IngredientToIngredientCommand;
import com.krykiet.spring5recipeapp.domain.Ingredient;
import com.krykiet.spring5recipeapp.domain.Recipe;
import com.krykiet.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Slf4j
@Controller
public class IngredientServiceImpl implements IngredientService {
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent()) {
            // TODO impl error handling
            log.error("recipe id not found" + recipeId);
        }
        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(!ingredientCommandOptional.isPresent()) {
            // TODO impl error handling
            log.error("ingredient id not found: " + ingredientId);
        }
        return ingredientCommandOptional.get();
    }
}
