package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.comments.DeleteComment;
import org.projet6.escalade.webapp.comments.PrintComments;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeleteComment deletedComment = new DeleteComment();
        deletedComment.removeComment(Integer.parseInt(request.getParameter("id")));

        this.getServletContext().getRequestDispatcher("/jsp/validation_delete.jsp").forward(request, response);
    }
}
