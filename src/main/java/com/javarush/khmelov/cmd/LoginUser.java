package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Collection;

public class LoginUser implements Command {
    private final UserService userService;

    public LoginUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String doPost(HttpServletRequest request) {
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Collection<User> allUsers = userService.getAll();
        for (User user : allUsers) {
            if (password.equals(user.getPassword()) && email.equals(user.getEmail()) && username.equals(user.getLogin())) {
                request.getSession().setAttribute("user", user);
                return "/";
            }
        }
        return getView();
    }
}
