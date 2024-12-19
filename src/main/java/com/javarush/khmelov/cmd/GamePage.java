package com.javarush.khmelov.cmd;

import com.javarush.khmelov.questions.GameRequestParams;
import com.javarush.khmelov.questions.laptop.GameStep;
import com.javarush.khmelov.questions.laptop.Option;
import com.javarush.khmelov.service.TextService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collection;
import java.util.List;

public class GamePage implements Command {
    private final TextService textService;

    public GamePage(TextService textService) {
        this.textService = textService;
    }

    @Override
    public String doGet(HttpServletRequest request) {
        startGame(request);

        return getView();
    }

    @Override
    public String doPost(HttpServletRequest request) {
        GameRequestParams gameRequestParams = GameRequestParams.parseRequestParameters(request);
        if (gameRequestParams.getResult() != null && !gameRequestParams.getResult().isEmpty()) {
            return checkWin(gameRequestParams.isEnd());
        }
        else {
            return "game-page?id=" + gameRequestParams.getId() + "&result=" + gameRequestParams.getResult() +
                    "&end=" + gameRequestParams.isEnd() + "&restart=" + gameRequestParams.isRestart();
        }
    }

    public void startGame(HttpServletRequest request) {
        GameRequestParams gameRequestParams = GameRequestParams.parseRequestParameters(request);
        if (gameRequestParams.getId() != -1) {
            String question = textService.getQuestion(gameRequestParams.getId());
            request.setAttribute("question", question);
            List<Option> options = textService.getOptionForStep(gameRequestParams.getId());
            request.setAttribute("options", options);
        } else
            throw new RuntimeException("no parameters");

    }

    public String checkWin(boolean win){
        if (win){
            return "win-game";
        } else
            return "lose-game";
    }


}
