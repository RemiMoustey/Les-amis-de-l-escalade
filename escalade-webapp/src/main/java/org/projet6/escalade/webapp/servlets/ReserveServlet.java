package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.topos.ReserveTopo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReserveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null) {
            ReserveTopo topo = new ReserveTopo();
            topo.updateAvailableTopo(request.getParameter("id"));
            topo.createAwaitingTopo(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("memberId")), (int) request.getSession().getAttribute("memberId"));

            this.getServletContext().getRequestDispatcher("/jsp/reserve.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
