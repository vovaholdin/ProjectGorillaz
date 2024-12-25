package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoginUserTest {

    private UserService userService;
    private HttpServletRequest request;
    private HttpSession session;
    private LoginUser loginUser;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        loginUser = new LoginUser(userService);

        when(request.getSession()).thenReturn(session);
    }


    @Test
    void testDoPostFailure() {
        String login = "testUser";
        String password = "wrongPassword";
        String email = "test@example.com";

        User user = new User("mr@gmail.com", 2L, "vova", "123", Role.USER, new StatisticUser(0,0,0));
        when(userService.getAll()).thenReturn(List.of(user));

        when(request.getParameter("login")).thenReturn(login);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getParameter("email")).thenReturn(email);

        String result = loginUser.doPost(request);
        assertEquals("login-user?alertMessage=%D0%9D%D0%B5%D0%B2%D0%B5%D1%80%D0%BD%D1%8B%D0%B9+%D0%BB%D0%BE%D0%B3%D0%B8%D0%BD+%D0%B8%D0%BB%D0%B8+%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D1%8C.+%D0%9F%D0%BE%D0%BF%D1%80%D0%BE%D0%B1%D1%83%D0%B9%D1%82%D0%B5+%D1%81%D0%BD%D0%BE%D0%B2%D0%B0.", result);
        verify(session, never()).setAttribute(eq("user"), any());
    }
}
