package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegisterUserTest{
    private RegisterUser registerUser;
    private UserService userService;
    private HttpServletRequest request;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        registerUser = new RegisterUser(userService);
    }

    @Test
    void checkRegister(){
        when(request.getParameter("email")).thenReturn("test@test.com");
        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("test");

        registerUser.doPost(request);
        verify(request).getParameter("email");
        verify(request).getParameter("login");
        verify(request).getParameter("password");
        verify(userService).create(any(User.class));
    }
}