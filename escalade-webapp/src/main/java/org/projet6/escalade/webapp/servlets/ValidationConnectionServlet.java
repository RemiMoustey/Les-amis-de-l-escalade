package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.members.ConnectedMember;
import org.projet6.escalade.webapp.members.RegisterMember;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ValidationConnectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/jsp/validation_connection.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login", request.getParameter("login"));
        request.setAttribute("password", request.getParameter("password"));
        ConnectedMember connectedMember = new ConnectedMember();
        connectedMember.connectMember(request);

        HttpSession session = request.getSession();
        session.setAttribute("login", request.getAttribute("login"));

        this.getServletContext().getRequestDispatcher("/jsp/validation_connection.jsp").forward(request, response);
    }
}
