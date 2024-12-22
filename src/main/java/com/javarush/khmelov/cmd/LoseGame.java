package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public class LoseGame implements Command {
    @Override
    public String doGet(HttpServletRequest request) {
        updateStatistic(request);
        String result = request.getParameter("result");
        request.setAttribute("result", result);
        return getView();
    }
    private void updateStatistic(HttpServletRequest request) {
        User user = request.getSession().getAttribute("user") != null ? (User) request.getSession().getAttribute("user") : null;
        assert user != null;
        user.getStatisticUsers().setLose(user.getStatisticUsers().getLose() + 1);
        user.getStatisticUsers().setScore(user.getStatisticUsers().getScore() + 1);
    }
}
