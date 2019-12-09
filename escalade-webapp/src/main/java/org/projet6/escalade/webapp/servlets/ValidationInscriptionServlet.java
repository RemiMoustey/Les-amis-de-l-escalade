package org.projet6.escalade.webapp.servlets;

import org.projet6.escalade.webapp.members.RegisterMember;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidationInscriptionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "UTF-8" );
        RegisterMember newMember = new RegisterMember();
        newMember.registerNewMember(request);

        this.getServletContext().getRequestDispatcher("/jsp/validation_inscription.jsp").forward(request, response);
    }
}
