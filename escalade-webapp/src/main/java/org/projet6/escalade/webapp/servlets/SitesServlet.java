package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.sites.PrintSites;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SitesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintSites sites = new PrintSites();
        sites.getSites(request);

        if(request.getParameter("add_site") != null) {
            request.setAttribute("addSite", request.getParameter("add_site"));
        }

        this.getServletContext().getRequestDispatcher("/jsp/sites.jsp").forward(request, response);
    }
}
