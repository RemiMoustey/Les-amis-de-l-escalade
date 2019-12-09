package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.topos.AcceptTopo;
import org.projet6.escalade.webapp.topos.ReserveTopo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeAvailableServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!new AcceptTopo().checkIfIsAuthorizedToUpdateAvailable(request)) {
            this.getServletContext().getRequestDispatcher("/jsp/errorPermission.jsp").forward(request, response);
        }
        else if(request.getSession().getAttribute("login") != null) {
            ReserveTopo newAvailableTopo = new ReserveTopo();
            newAvailableTopo.makeAvailable(Integer.parseInt(request.getParameter("id")), true);
            response.sendRedirect("/dashboard?id=" + request.getSession().getAttribute("memberId") + "&update_available=true");
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
