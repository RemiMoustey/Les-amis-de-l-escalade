package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.sites.OfficialSites;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeUnofficialServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null) {
            OfficialSites newOfficialSite = new OfficialSites();
            newOfficialSite.makeOfficial(Integer.parseInt(request.getParameter("id")), false);

            response.sendRedirect("/one_site?id=" + request.getSession().getAttribute("siteId") + "&site=" + request.getSession().getAttribute("siteName") + "&make_unofficial=true");
        }
        else if (request.getSession().getAttribute("adminConnected") == null) {
            this.getServletContext().getRequestDispatcher("/jsp/errorPermission.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
