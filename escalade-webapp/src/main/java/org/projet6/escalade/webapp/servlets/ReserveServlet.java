package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.topos.ReserveTopo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReserveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getSession().getAttribute("memberId").toString().equals(request.getParameter("buyer_id"))) {
            this.getServletContext().getRequestDispatcher("/jsp/errorPermission.jsp").forward(request, response);
        }
        else if(!new ReserveTopo().checkIfIdAndMemberIdMatch(request)) {
            this.getServletContext().getRequestDispatcher("/jsp/errorNoMatch.jsp").forward(request, response);
        }
        else if(request.getSession().getAttribute("login") != null) {
            ReserveTopo topo = new ReserveTopo();
            topo.updateAvailableTopo(request.getParameter("id"));
            topo.createAwaitingTopo(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("member_id")), (int) request.getSession().getAttribute("memberId"));

            response.sendRedirect("/topos?id=" + request.getSession().getAttribute("memberId") + "&reserve=true");
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
