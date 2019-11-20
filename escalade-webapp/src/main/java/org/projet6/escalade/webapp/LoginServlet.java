package org.projet6.escalade.webapp;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }
}
