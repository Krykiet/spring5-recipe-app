package com.krykiet.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Annotating Spring Component
@Controller
public class IndexController {

    // URL values to call method
    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndexPage() {
        System.out.println("Some message to say....");
        return "index";
    }
}
