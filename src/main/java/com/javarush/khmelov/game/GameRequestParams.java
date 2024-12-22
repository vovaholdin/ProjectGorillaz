package com.javarush.khmelov.game;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameRequestParams {

    private int id;
    private String result;
    private boolean restart;
    private boolean end;

    public static GameRequestParams parseRequestParameters(HttpServletRequest request) {
        String result = request.getParameter("result");
        String endParam = request.getParameter("end");
        String restartParam = request.getParameter("restart");
        String idParam = request.getParameter("id");
        int id = -1; // значение по умолчанию, если параметр не указан или пуст
        if (idParam != null && !idParam.trim().isEmpty()) {
            try {
                id = Integer.parseInt(idParam);
            } catch (NumberFormatException e) {
                // В случае ошибки парсинга, id останется -1, можно логировать ошибку
                System.err.println("Invalid ID parameter: " + idParam);
            }
        }
        boolean restart = "true".equalsIgnoreCase(restartParam);
        boolean end = "true".equalsIgnoreCase(endParam);
        return new GameRequestParams(id, result, restart, end);
    }
}
