package com.javarush.khmelov.cmd;

import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class WinGameTest {

    private WinGame winGame;
    private HttpServletRequest request;
    private HttpSession session;
    private User mockUser;

    @BeforeEach
    void setUp() {
        winGame = new WinGame();
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        mockUser = User.builder()
                .login("testUser")
                .email("test@example.com")
                .password("password")
                .statisticUsers(new StatisticUser(3, 5, 10))
                .build();

        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testDoGetUpdatesStatisticAndReturnsView() {

        when(session.getAttribute("user")).thenReturn(mockUser);


        String view = winGame.doGet(request);

        assertEquals(winGame.getView(), view);

        StatisticUser stats = mockUser.getStatisticUsers();
        assertEquals(11, stats.getWin());
        assertEquals(4, stats.getScore());
    }

    @Test
    void testDoGetHandlesNullUser() {
        when(session.getAttribute("user")).thenReturn(null);

        assertThrows(AssertionError.class, () -> winGame.doGet(request));
    }
}
