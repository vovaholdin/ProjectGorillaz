package com.javarush.khmelov.service;

import com.javarush.khmelov.repository.InMemoryTextRepository;
import com.javarush.khmelov.repository.TextRepository;

public class TextService {
    private final InMemoryTextRepository repository;

    public TextService(InMemoryTextRepository repository) {
        this.repository = repository;
    }

    public String getQuestion(int id) {
        return repository.getQuestion(id);
    }


    public String getCorrectAnswer(int id) {
        return repository.getCorrectAnswer(id);
    }


    public String getWrongAnswer(int id) {
        return repository.getWrongAnswer(id);
    }

}
