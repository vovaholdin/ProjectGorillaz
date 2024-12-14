package com.javarush.khmelov.repository;

import com.javarush.khmelov.jsonHelper.JsonReader;
import com.javarush.khmelov.questions.laptop.BrokenLaptop;

import java.io.IOException;
import java.util.List;

public class InMemoryTextRepository implements TextRepository{
    private final List<BrokenLaptop> allQuestions;
    public InMemoryTextRepository(JsonReader reader) throws IOException {
        allQuestions = reader.readQuestionsFromJson();
    }


    @Override
    public String getQuestion(int id) {
        return allQuestions.get(id).getQuestion();
    }

    @Override
    public String getCorrectAnswer(int id) {
        return allQuestions.get(id).getCorrectAnswer();
    }

    @Override
    public String getWrongAnswer(int id) {
        return allQuestions.get(id).getWrongAnswer();
    }
}
