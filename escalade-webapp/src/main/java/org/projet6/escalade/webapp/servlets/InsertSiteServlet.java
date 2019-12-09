package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.sites.PrintSites;
import org.projet6.escalade.webapp.sites.RegisterSite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InsertSiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "UTF-8" );
        RegisterSite registerSite = new RegisterSite();
        registerSite.registerNewSite(request);

        response.sendRedirect("/sites?add_site=true");
    }
}
