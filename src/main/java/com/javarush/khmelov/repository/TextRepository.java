package com.javarush.khmelov.repository;

import com.javarush.khmelov.questions.laptop.GameStep;
import com.javarush.khmelov.questions.laptop.Option;

import java.util.List;

public interface TextRepository {
    String getQuestion(int id); // получение вопроса
    GameStep getStepById(int id); // получение следующего шага по айди
    List<Option> getOptionForStep(int id); // получение всех вариантов ответа
    GameStep getNextStep(int currentStepId, String selectedOptionText); // получение следующего шага исходя из предыдущего ответа
    String getResultForOption(int currentStepId, String selectedOptionText); //получение ресультата в виде текста после ответа пользователя
    Boolean shouldRestartGame(int currentStepId, String selectedOptionText); // проверка на рестарт
    Boolean isGameOver(int currentStepId, String selectedOptionText); // проверка на конец игры
    String getQuestionByStepId(int id); // 2 получение вопроса (временно)
}
