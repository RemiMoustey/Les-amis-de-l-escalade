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

        this.getServletContext().getRequestDispatcher("/jsp/one_site.jsp").forward(request, response);
    }
}
