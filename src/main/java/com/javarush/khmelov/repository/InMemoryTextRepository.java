package com.javarush.khmelov.repository;

import com.javarush.khmelov.jsonHelper.JsonReader;
import com.javarush.khmelov.questions.laptop.GameStep;
import com.javarush.khmelov.questions.laptop.Option;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InMemoryTextRepository implements TextRepository{
    private final Map<Integer, GameStep> allQuestions;
    public InMemoryTextRepository(JsonReader reader) throws IOException {
        allQuestions = reader.loadStepsFromJson();
    }

    @Override
    public String getQuestion(int id) {
        return allQuestions.get(id).getQuestion();
    }

    @Override
    public GameStep getStepById(int id) {
        return allQuestions.get(id);
    }

    @Override
    public List<Option> getOptionForStep(int id) {
        GameStep step = allQuestions.get(id);
        return step != null ? step.getOptions() : null;
    }

    @Override
    public GameStep getNextStep(int currentStepId, String selectedOptionText) {
        GameStep currentStep = allQuestions.get(currentStepId);
        if (currentStep != null){
            for (Option option : currentStep.getOptions()) {
                if (option.getText().equals(selectedOptionText)) {
                    return getStepById(option.getNextStep());
                }
            }
        }
        return null;
    }

    @Override
    public String getResultForOption(int currentStepId, String selectedOptionText) {
        GameStep currentStep = allQuestions.get(currentStepId);
        if (currentStep != null){
            for (Option option : currentStep.getOptions()) {
                if (option.getText().equals(selectedOptionText)) {
                    return option.getResult() == null ? "" : option.getResult();
                }
            }
        }
        return "";
    }

    @Override
    public Boolean shouldRestartGame(int currentStepId, String selectedOptionText) {
        GameStep currentStep = allQuestions.get(currentStepId);
        if (currentStep != null){
            for (Option option : currentStep.getOptions()) {
                if (option.getText().equals(selectedOptionText)) {
                    return option.getRestart() != null && option.getRestart();
                }
            }
        }
        return false;
    }

    @Override
    public Boolean isGameOver(int currentStepId, String selectedOptionText) {
        GameStep currentStep = allQuestions.get(currentStepId);
        if (currentStep != null){
            for (Option option : currentStep.getOptions()) {
                if (option.getText().equals(selectedOptionText)) {
                    return option.getEnd() != null && option.getEnd();
                }
            }
        }
        return false;
    }



}
