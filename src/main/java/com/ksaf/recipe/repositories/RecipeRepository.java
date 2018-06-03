package com.ksaf.recipe.repositories;

import com.ksaf.recipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
