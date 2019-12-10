package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.comments.DeleteComment;
import org.projet6.escalade.webapp.comments.PrintComments;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet manages the removal of a comment and the redirection
 */
public class DeleteCommentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null) {
            DeleteComment deletedComment = new DeleteComment();
            deletedComment.removeComment(Integer.parseInt(request.getParameter("id")));

            response.sendRedirect("/one_site?id=" + request.getSession().getAttribute("siteId") + "&site=" + request.getSession().getAttribute("siteName") + "&delete_comment=true");
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
