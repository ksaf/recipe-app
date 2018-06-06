package com.ksaf.recipe.services;

import com.ksaf.recipe.commands.RecipeCommand;
import com.ksaf.recipe.models.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findRecipeById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
