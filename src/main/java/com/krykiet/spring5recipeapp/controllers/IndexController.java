package com.krykiet.spring5recipeapp.controllers;

import com.krykiet.spring5recipeapp.domain.Category;
import com.krykiet.spring5recipeapp.domain.UnitOfMeasure;
import com.krykiet.spring5recipeapp.repositories.CategoryRepository;
import com.krykiet.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

// Annotating Spring Component
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    // URL values to call method
    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        System.out.println("Cat ID is: " + categoryOptional.get().getId());
        System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());

        System.out.println("Some message to say....");
        return "index";
    }
}
