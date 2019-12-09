package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.comments.RegisterComment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertCommentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "UTF-8" );
        RegisterComment registerComment = new RegisterComment();
        registerComment.registerNewComment(request);

        response.sendRedirect("/one_site?id=" + request.getSession().getAttribute("siteId") + "&site=" + request.getSession().getAttribute("siteName") + "&add_comment=true");
    }
}
