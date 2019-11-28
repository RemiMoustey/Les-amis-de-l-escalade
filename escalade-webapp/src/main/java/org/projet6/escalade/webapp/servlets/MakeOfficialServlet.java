package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.sites.OfficialSites;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeOfficialServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficialSites newOfficialSite = new OfficialSites();
        newOfficialSite.makeOfficial(Integer.parseInt(request.getParameter("id")), true);

        this.getServletContext().getRequestDispatcher("/jsp/validation_official.jsp").forward(request, response);
    }
}
