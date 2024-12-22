package com.javarush.khmelov.service;

import com.javarush.khmelov.game.laptop.GameStep;
import com.javarush.khmelov.game.laptop.Option;
import com.javarush.khmelov.repository.InMemoryTextRepository;

import java.util.List;

public class TextService {
    private final InMemoryTextRepository repository;

    public TextService(InMemoryTextRepository repository) {
        this.repository = repository;
    }

    public String getQuestion(int id) {
        return repository.getQuestion(id);
    }
    public GameStep getStepById(int id) {
        return repository.getStepById(id);
    }
    public List<Option> getOptionForStep(int id) {
        return repository.getOptionForStep(id);
    }
    public GameStep getNextStep(int currentStepId, String selectedOptionText){
        return repository.getNextStep(currentStepId, selectedOptionText);
    }
    public String getResultForOption(int currentStepId, String selectedOptionText){
        return repository.getResultForOption(currentStepId, selectedOptionText);
    }
    public Boolean shouldRestartGame(int currentStepId, String selectedOptionText){
        return repository.shouldRestartGame(currentStepId, selectedOptionText);
    }
    public Boolean isGameOver(int currentStepId, String selectedOptionText){
        return repository.isGameOver(currentStepId, selectedOptionText);
    }






}
