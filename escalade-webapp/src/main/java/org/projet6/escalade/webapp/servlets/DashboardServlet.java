package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.members.ShowMembers;
import org.projet6.escalade.webapp.topos.PrintTopos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null) {
            PrintTopos topos = new PrintTopos();
            topos.getToposMember(request, Integer.parseInt(request.getParameter("id")));
            topos.getAwaitingTopos(request, Integer.parseInt(request.getParameter("id")));
            topos.getDataAwaitingTopos(request, Integer.parseInt(request.getParameter("id")), "member");

            ShowMembers members = new ShowMembers();
            request.setAttribute("allMembers", members.getListMembers());

            this.getServletContext().getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
