package com.javarush.khmelov.controller;

import com.javarush.khmelov.cmd.Command;
import com.javarush.khmelov.config.Winter;
import jakarta.servlet.http.HttpServletRequest;

public class HttpResolver {

    public Command resolve(HttpServletRequest request) {
