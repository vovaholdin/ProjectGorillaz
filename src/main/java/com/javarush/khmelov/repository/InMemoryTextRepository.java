package com.javarush.khmelov.repository;

import com.javarush.khmelov.jsonHelper.JsonReader;
import com.javarush.khmelov.questions.InterviewQuestions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTextRepository implements TextRepository{
    private final List<InterviewQuestions> allQuestions;
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
