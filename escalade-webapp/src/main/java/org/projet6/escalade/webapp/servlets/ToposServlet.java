package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.topos.PrintTopos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToposServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintTopos availableTopos = new PrintTopos();
        availableTopos.getAvailableTopos(request, Integer.parseInt(request.getParameter("id")));

        availableTopos.getDataAwaitingTopos(request, Integer.parseInt(request.getParameter("id")), "buyer");

        this.getServletContext().getRequestDispatcher("/jsp/topos.jsp").forward(request, response);
    }
}
