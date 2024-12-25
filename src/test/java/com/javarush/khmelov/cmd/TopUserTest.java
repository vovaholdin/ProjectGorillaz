package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TopUserTest {

    private TopUser topUser;
    private UserService userService;
    private HttpServletRequest request;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        request = mock(HttpServletRequest.class);
        topUser = new TopUser(userService);
    }

    @Test
    void testDoGetReturnsViewAndSetsUsersAttribute() {
        Collection<User> mockUsers = new ArrayList<>();
        mockUsers.add(User.builder()
                .login("user1")
                .email("user1@example.com")
                .password("password1")
                .role(Role.USER)
                .statisticUsers(new StatisticUser(10, 2, 5))
                .build());
        mockUsers.add(User.builder()
                .login("user2")
                .email("user2@example.com")
                .password("password2")
                .role(Role.USER)
                .statisticUsers(new StatisticUser(15, 3, 7))
                .build());

        when(userService.getAll()).thenReturn(mockUsers);

        String view = topUser.doGet(request);

        verify(request).setAttribute("users", mockUsers);
        assertEquals(topUser.getView(), view);
    }

    @Test
    void testDoGetHandlesEmptyUsersList() {
        Collection<User> emptyUsers = new ArrayList<>();
        when(userService.getAll()).thenReturn(emptyUsers);

        String view = topUser.doGet(request);

        verify(request).setAttribute("users", emptyUsers);
        assertEquals(topUser.getView(), view);
    }
}
