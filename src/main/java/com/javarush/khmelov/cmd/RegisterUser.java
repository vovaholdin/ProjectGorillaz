package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.service.TextService;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

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
