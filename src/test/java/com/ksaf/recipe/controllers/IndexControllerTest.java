package com.ksaf.recipe.controllers;

import com.ksaf.recipe.models.Recipe;
import com.ksaf.recipe.services.RecipeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IndexControllerTest {

    private IndexController indexController;
    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void getIndexPage() {
        //Setup
        Set<Recipe> expectedRecipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        expectedRecipes.add(recipe1);
        expectedRecipes.add(recipe2);
        Mockito.when(recipeService.getRecipes()).thenReturn(expectedRecipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String expectedString = "index";
        //Test
        String actualString = indexController.getIndexPage(model);
        //Verify
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
        Assert.assertEquals(expectedString, actualString);
        Set<Recipe> actualRecipes = argumentCaptor.getValue();
        Assert.assertEquals(2, actualRecipes.size());
    }
}