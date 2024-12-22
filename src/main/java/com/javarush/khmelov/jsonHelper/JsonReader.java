package com.javarush.khmelov.jsonHelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.khmelov.game.laptop.GameStep;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonReader {
    private Map<Integer, GameStep> stepsMap = new HashMap<>();

    public Map<Integer, GameStep> loadStepsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Используем ClassLoader для загрузки файла из папки resources
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource("games/broken-laptop.json");

            if (resource == null) {
                throw new IllegalArgumentException("Файл не найден: games/broken-laptop.json");
            }

            File file = new File(resource.toURI());

            // Создаем объект, в который будем десериализовывать данные
            GameStepsWrapper wrapper = objectMapper.readValue(file, GameStepsWrapper.class);

            // Сохраняем шаги в HashMap для быстрого доступа по ID
            for (GameStep step : wrapper.getSteps()) {
                stepsMap.put(step.getId(), step);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return stepsMap;
    }

    // Вспомогательный класс для обертки списка шагов
    public static class GameStepsWrapper {
        private List<GameStep> steps;

        public List<GameStep> getSteps() {
            return steps;
        }

        public void setSteps(List<GameStep> steps) {
            this.steps = steps;
        }
    }
}
