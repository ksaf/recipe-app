package com.ksaf.recipe.repositories;

import com.ksaf.recipe.models.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository <UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

}
