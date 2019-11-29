<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 29/11/2019
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="fr">
    <head>
        <%@ include file="header.jsp" %>
        <title>Espace personnel</title>
    </head>
    <body>
        <%@ include file="/jsp/menu.jsp" %>
        <div class="content">
            <h1>Bienvenue dans votre espace personne <c:out value="${sessionScope.login}" /></h1>
            <p>
                <a href="/register_topo">Enregistrer un topo</a>
            </p>
            <h2>Vos topos</h2>

        </div>
    </body>
</html>
