package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EditUserTest {
    private EditUser editUser;

    @Mock
    private UserService mockUserService;

    @Mock
    private HttpServletRequest mockRequest;

    @BeforeEach
    void setUp() {
        editUser = new EditUser(mockUserService);
    }

    @Test
    void doGet() {
        User user = new User("test@gmail.com", 1L, "Test", "test", Role.USER, new StatisticUser(1, 1, 1));
        Mockito.when(mockRequest.getParameter("id")).thenReturn("1");
        Mockito.when(mockUserService.get(1)).thenReturn(Optional.of(user));
        editUser.doGet(mockRequest);
        Mockito.verify(mockRequest).setAttribute("user", user);
    }

}