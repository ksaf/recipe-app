package com.ksaf.recipe.services;

import com.ksaf.recipe.models.Recipe;
import com.ksaf.recipe.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeServiceImplTest {

    private RecipeService recipeService;
    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
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