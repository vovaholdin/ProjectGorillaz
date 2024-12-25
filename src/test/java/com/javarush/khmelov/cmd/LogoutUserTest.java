package com.javarush.khmelov.cmd;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LogoutUserTest {

    private LogoutUser logoutUser;
    private HttpServletRequest request;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        logoutUser = new LogoutUser();
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testDoPost() {
        String result = logoutUser.doPost(request);

        assertEquals("/", result);
        verify(session).invalidate(); // Проверяем, что сессия была завершена
    }
}
