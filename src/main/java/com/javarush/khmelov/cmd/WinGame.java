package com.javarush.khmelov.cmd;

import jakarta.servlet.http.HttpServletRequest;

public class WinGame implements Command {
    @Override
    public String doGet(HttpServletRequest request) {
        return Command.super.doGet(request);
    }
}
