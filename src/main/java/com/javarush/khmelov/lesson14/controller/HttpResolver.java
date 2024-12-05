package com.javarush.khmelov.lesson14.controller;

import com.javarush.khmelov.lesson14.cmd.Command;
import com.javarush.khmelov.lesson14.cmd.EditUser;
import com.javarush.khmelov.lesson14.cmd.Home;
import com.javarush.khmelov.lesson14.cmd.ListUser;
import jakarta.servlet.http.HttpServletRequest;

public enum HttpResolver {

    HOME(new Home()),
    EDIT_USER(new EditUser()),
    LIST_USER(new ListUser());


    private final Command command;

    HttpResolver(Command command) {
        this.command = command;
    }

    public static Command resolve(HttpServletRequest request) {
        //   /cmd-example
        String requestURI = request.getRequestURI();
        requestURI = requestURI.equals("/") ? "/home" : requestURI;
        String cmdName = requestURI.split("[?#/]")[1];
        String enumValue = cmdName.toUpperCase().replace("-", "_");
        return HttpResolver.valueOf(enumValue).command;
    }
}
