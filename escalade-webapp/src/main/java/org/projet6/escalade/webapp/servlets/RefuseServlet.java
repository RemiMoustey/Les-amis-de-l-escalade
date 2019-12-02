package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.topos.RefuseTopo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RefuseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RefuseTopo refuseTopo = new RefuseTopo();
        refuseTopo.refuseTopo(Integer.parseInt(request.getParameter("id")));

        this.getServletContext().getRequestDispatcher("/jsp/refuse.jsp").forward(request, response);

    }
}
