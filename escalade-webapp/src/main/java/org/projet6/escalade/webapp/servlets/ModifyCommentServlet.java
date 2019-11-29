package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.comments.PrintComments;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyCommentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null) {
            PrintComments modifiedComment = new PrintComments();
            modifiedComment.getOneCommment(request, Integer.parseInt(request.getParameter("id")));

            this.getServletContext().getRequestDispatcher("/jsp/validation_unofficial.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
