package com.javarush.khmelov.repository;

public interface TextRepository {
    String getQuestion(int id);
    String getCorrectAnswer(int id);
    String getWrongAnswer(int id);
}
