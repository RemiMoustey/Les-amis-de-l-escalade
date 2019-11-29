package org.projet6.escalade.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null) {
            this.getServletContext().getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
