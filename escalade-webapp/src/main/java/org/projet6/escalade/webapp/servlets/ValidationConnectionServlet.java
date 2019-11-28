package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.consumer.contract.dao.MemberDao;
import org.projet6.escalade.model.bean.member.Member;
import org.projet6.escalade.webapp.members.RegisterMember;
import org.projet6.escalade.webapp.members.ShowMembers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ValidationConnectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/jsp/validation_connection.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Member> registeredMembers = new ShowMembers().getListMembers();
        HttpSession session = request.getSession();
        for(int i = 0; i < registeredMembers.size(); i++) {
            if (registeredMembers.get(i).getLogin().equals(request.getParameter("login")) && registeredMembers.get(i).getPassword().equals(request.getParameter("password"))) {
                request.setAttribute("login", request.getParameter("login"));
                request.setAttribute("password", request.getParameter("password"));
                break;
            }
        }

        if(request.getAttribute("login") == null) {
            session.setAttribute("error", "Identifiants incorrects");
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            return;
        }

        RegisterMember connectedMember = new RegisterMember();
        connectedMember.getOneMember(request, (String) request.getAttribute("login"), (String) request.getAttribute("password"));
        session.setAttribute("login", request.getAttribute("login"));
        session.setAttribute("adminConnected", request.getAttribute("adminConnected"));

        this.getServletContext().getRequestDispatcher("/jsp/validation_connection.jsp").forward(request, response);
    }
}
