package org.projet6.escalade.webapp.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getParameter("logout") != null) {
            request.setAttribute("logout", request.getParameter("logout"));
        }

        this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}
