package com.javarush.khmelov.cmd;

import com.javarush.khmelov.questions.laptop.GameStep;
import com.javarush.khmelov.service.TextService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Collection;

public class GamePage implements Command {
    private final TextService textService;

    public GamePage(TextService textService) {
        this.textService = textService;
    }

    @Override
    public String doGet(HttpServletRequest request) {
        String question = textService.getQuestion(1);
        request.setAttribute("question", question);
        return getView();
    }

    @Override
    public String doPost(HttpServletRequest request) {
        return Command.super.doPost(request);
    }
}
