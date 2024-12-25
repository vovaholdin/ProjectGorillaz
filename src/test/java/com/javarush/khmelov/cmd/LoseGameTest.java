package com.javarush.khmelov.cmd;


import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoseGameTest {

    private LoseGame loseGame;
    private HttpServletRequest request;
    private HttpSession session;
    private User user;

    @BeforeEach
    void setUp() {
        loseGame = new LoseGame();
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        user = new User();
        user.setStatisticUsers(new StatisticUser(0, 0, 0));

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
    }

    @Test
    void testDoGet() {
        String expectedView = "lose-game"; // Замените на фактический путь, возвращаемый getView()
        String resultParam = "You lost!";
        when(request.getParameter("result")).thenReturn(resultParam);

        String result = loseGame.doGet(request);

        assertEquals(expectedView, result);
        verify(request).setAttribute("result", resultParam);
        assertEquals(1, user.getStatisticUsers().getLose());
        assertEquals(1, user.getStatisticUsers().getScore());
    }

    @Test
    void testUpdateStatistic() {
        loseGame.doGet(request);

        assertEquals(1, user.getStatisticUsers().getLose());
        assertEquals(1, user.getStatisticUsers().getScore());
    }

}
