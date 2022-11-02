package com.krykiet.spring5recipeapp.controllers;

import com.krykiet.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
