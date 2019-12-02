package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.members.RegisterMember;
import org.projet6.escalade.webapp.topos.RegisterTopo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InsertTopoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        RegisterMember member = new RegisterMember();
        member.getOneMember(request, (String) session.getAttribute("login"), (String) session.getAttribute("password"));
        RegisterTopo registerTopo = new RegisterTopo();
        registerTopo.createNewTopo(request, (int) request.getAttribute("memberId"));

        this.getServletContext().getRequestDispatcher("/jsp/validation_topo.jsp").forward(request, response);
    }

}
