package com.javarush.khmelov.cmd;

import com.javarush.khmelov.game.GameRequestParams;
import com.javarush.khmelov.service.TextService;
import com.javarush.khmelov.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GamePageTest {
    private GamePage gamePage;
    @Mock
    private TextService mockTextService;

    @Mock
    private HttpServletRequest mockRequest;

    @BeforeEach
    void setUp() {
        gamePage = new GamePage(mockTextService);
    }


    @Test
    void startGame() {
        Mockito.when(mockRequest.getParameter("id")).thenReturn("1");
        Mockito.when(mockRequest.getParameter("restart")).thenReturn("true");
        Mockito.when(mockRequest.getParameter("result")).thenReturn("result");
        Mockito.when(mockRequest.getParameter("end")).thenReturn("false");
        GameRequestParams gameRequestParams = GameRequestParams.parseRequestParameters(mockRequest);
        gamePage.checkWin(true, gameRequestParams);
        Mockito.verify(mockRequest).getParameter("id");
        assertEquals("result", mockRequest.getParameter("result"));


    }

}