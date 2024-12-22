package com.javarush.khmelov.repository;

import com.javarush.khmelov.jsonHelper.JsonReader;
import com.javarush.khmelov.game.laptop.GameStep;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class InMemoryTextRepositoryTest {
    @Test
    public void testRepositoryLoadsSteps() throws IOException {
        JsonReader jsonReader = new JsonReader();
        InMemoryTextRepository repository = new InMemoryTextRepository(jsonReader);

        GameStep step = repository.getStepById(1);
        assertNotNull(step, "Step should be loaded from repository");
        assertEquals("У вас сломался кулер", step.getQuestion(), "The question should match the expected");
    }

  
}