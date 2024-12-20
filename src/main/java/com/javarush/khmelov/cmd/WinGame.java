package com.javarush.khmelov.cmd;

import jakarta.servlet.http.HttpServletRequest;

public class WinGame implements Command {
    @Override
    public String doGet(HttpServletRequest request) {
        String result = request.getParameter("result");
        request.setAttribute("result", result);
        return getView();
    }
}
