package com.ksaf.recipe.repositories;

import com.ksaf.recipe.models.UnitOfMeasure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByDescription() {
        String stringToSearchFor = "Teaspoon";
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription(stringToSearchFor);

        Assert.assertEquals(stringToSearchFor, unitOfMeasure.get().getDescription());
    }
}