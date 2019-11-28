package org.projet6.escalade.webapp.servlets;


import org.projet6.escalade.webapp.comments.RegisterComment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCommentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/validation_update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterComment updatedComment = new RegisterComment();
        updatedComment.changeComment((int) request.getSession().getAttribute("commentId"), request.getParameter("author"), request.getParameter("comment"));

        this.getServletContext().getRequestDispatcher("/jsp/validation_update.jsp").forward(request, response);
    }
}
