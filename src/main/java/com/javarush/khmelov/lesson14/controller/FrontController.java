package com.javarush.khmelov.lesson14.controller;

import com.javarush.khmelov.lesson14.cmd.Command;
import com.javarush.khmelov.lesson14.entity.Role;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"", "/home", "/list-user", "/edit-user"})
public class FrontController extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        config.getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = HttpResolver.resolve(req);
        String view = command.doGet(req);
        String jsp = "/WEB-INF/" + view + ".jsp";
        req.getRequestDispatcher(jsp).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = HttpResolver.resolve(req);
        String redirect = command.doPost(req);
        resp.sendRedirect(redirect);
    }
}
