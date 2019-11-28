package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.sites.OfficialSites;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeUnofficialServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficialSites newOfficialSite = new OfficialSites();
        newOfficialSite.makeOfficial(Integer.parseInt(request.getParameter("id")), false);

        this.getServletContext().getRequestDispatcher("/jsp/validation_unofficial.jsp").forward(request, response);
    }
}
