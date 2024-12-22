package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;
import com.javarush.khmelov.service.TextService;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class RegisterUser implements Command {
    private final UserService userService;

    public RegisterUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String doPost(HttpServletRequest request) {
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = User.builder()
                .login(username)
                .email(email)
                .password(password)
                .role(Role.USER)
                .statisticUsers(new StatisticUser(0,0,0))
                .build();
        if (userService.isUserInMemory(user)) {
            System.err.println("This login already exists");
        } else {
            userService.create(user);
            request.getSession().setAttribute("user", user);
            return "/";
        }
        return getView();
    }
}
