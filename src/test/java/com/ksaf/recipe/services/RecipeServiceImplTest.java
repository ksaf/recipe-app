package com.ksaf.recipe.services;

import com.ksaf.recipe.converters.RecipeCommandToRecipe;
import com.ksaf.recipe.converters.RecipeToRecipeCommand;
import com.ksaf.recipe.models.Recipe;
import com.ksaf.recipe.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeServiceImplTest {

    private RecipeService recipeService;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);
        Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(optionalRecipe);

        Recipe recipeReturned = recipeService.findRecipeById(1L);

        Assert.assertNotNull("Null recipe returned", recipeReturned);
        Mockito.verify(recipeRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(recipeRepository, Mockito.never()).findAll();
    }

    @Test
    public void getRecipes() {
        Recipe fakeRecipe = new Recipe();
        Set<Recipe> fakeRecipes = new HashSet<>();
        fakeRecipes.add(fakeRecipe);
        Mockito.when(recipeRepository.findAll()).thenReturn(fakeRecipes);

        Assert.assertEquals(1, recipeService.getRecipes().size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}