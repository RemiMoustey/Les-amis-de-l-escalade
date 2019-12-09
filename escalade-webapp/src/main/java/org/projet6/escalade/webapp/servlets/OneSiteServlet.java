package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.comments.PrintComments;
import org.projet6.escalade.webapp.sites.PrintSites;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneSiteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        PrintSites sites = new PrintSites();
        sites.getOneSite(request);

        PrintComments comments = new PrintComments();
        comments.getComments(request);

        if(request.getParameter("add_comment") != null) {
            request.setAttribute("addComment", request.getParameter("add_comment"));
        }

        if(request.getParameter("modify_comment") != null) {
            request.setAttribute("modifyComment", request.getParameter("modify_comment"));
        }

        if(request.getParameter("delete_comment") != null) {
            request.setAttribute("deleteComment", request.getParameter("delete_comment"));
        }

        if(request.getParameter("make_official") != null) {
            request.setAttribute("makeOfficial", request.getParameter("make_official"));
        }

        if(request.getParameter("make_unofficial") != null) {
            request.setAttribute("makeUnofficial", request.getParameter("make_unofficial"));
        }

        this.getServletContext().getRequestDispatcher("/jsp/one_site.jsp").forward(request, response);
    }
}
