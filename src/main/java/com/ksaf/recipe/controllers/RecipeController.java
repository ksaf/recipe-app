package com.ksaf.recipe.controllers;

import com.ksaf.recipe.models.Recipe;
import com.ksaf.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String getShowPageById(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findRecipeById(Long.parseLong(id));
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }
}
