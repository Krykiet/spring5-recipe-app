package com.krykiet.spring5recipeapp.controllers;

import com.krykiet.spring5recipeapp.commands.RecipeCommand;
import com.krykiet.spring5recipeapp.services.RecipeService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.Long.valueOf;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // link address, {id} is passed as parameter
    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        // content of the HTML in the model
        model.addAttribute("recipe", recipeService.findById(valueOf(id)));
        // selecting a template
        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        // passes new RecipeCommand object to recipeform template
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    // HTTP POST request
    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/show/" + savedCommand.getId();
    }
}
