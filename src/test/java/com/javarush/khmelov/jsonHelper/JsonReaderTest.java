package com.javarush.khmelov.jsonHelper;

import com.javarush.khmelov.questions.laptop.GameStep;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
    @Test
    public void testLoadStepsFromJson() {
        // Указываем путь к файлу JSON


        // Создаем объект JsonReader
        JsonReader jsonReader = new JsonReader();

        // Загружаем данные из JSON
        Map<Integer, GameStep> steps = jsonReader.loadStepsFromJson();

        // Проверяем, что данные были загружены
        assertNotNull(steps, "Steps map should not be null");
        assertTrue(steps.size() > 0, "Steps map should contain data");

        // Проверка на конкретный шаг
        GameStep firstStep = steps.get(1);
        assertNotNull(firstStep, "First step should not be null");
        assertEquals("У вас сломался кулер", firstStep.getQuestion(), "First question should match");
    }
}

