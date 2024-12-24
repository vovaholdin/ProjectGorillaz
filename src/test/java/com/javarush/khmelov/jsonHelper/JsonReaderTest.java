package com.javarush.khmelov.jsonHelper;

import com.javarush.khmelov.game.laptop.GameStep;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
    @Test
    public void testLoadStepsFromJson() {
        JsonReader jsonReader = new JsonReader();
        Map<Integer, GameStep> steps = jsonReader.loadStepsFromJson();
        assertNotNull(steps, "Steps map should not be null");
        assertFalse(steps.isEmpty(), "Steps map should contain data");
        GameStep firstStep = steps.get(1);
        assertNotNull(firstStep, "First step should not be null");
        assertEquals("У вас сломался кулер. Что будете делать?", firstStep.getQuestion(), "First question should match");
    }
}

