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
        request.setCharacterEncoding( "UTF-8" );
        HttpSession session =  request.getSession();
        RegisterMember member = new RegisterMember();
        member.getOneMember(request, (String) session.getAttribute("login"), (String) session.getAttribute("password"));
        RegisterTopo registerTopo = new RegisterTopo();
        registerTopo.createNewTopo(request, (int) request.getAttribute("memberId"));

        response.sendRedirect("/dashboard?id=" + request.getSession().getAttribute("memberId") + "&add_topo=true");
    }

}
