package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.topos.AcceptTopo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AcceptServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AcceptTopo acceptTopo = new AcceptTopo();
        acceptTopo.acceptTopo(Integer.parseInt(request.getParameter("id")));

        response.sendRedirect("/dashboard?id=" + request.getParameter("member_id") + "&buyer_id=" + request.getParameter("buyer_id") + "&accept=true");
    }
}
