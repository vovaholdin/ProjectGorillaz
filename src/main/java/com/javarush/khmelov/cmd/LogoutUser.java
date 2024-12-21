package com.javarush.khmelov.cmd;

import jakarta.servlet.http.HttpServletRequest;

public class LogoutUser implements Command {
    @Override
    public String doPost(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/";
    }
}
