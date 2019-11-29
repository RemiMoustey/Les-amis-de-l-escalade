package org.projet6.escalade.webapp.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") == null) {
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/sites");
        }
    }
}
