<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 13/11/2019
  Time: 08:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">

    <head>
        <%@ include file="header.jsp" %>
        <title>Se connecter - Les amis de l'escalade</title>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <div class="content">
            <c:if test="${addMember != null}">
                <div class="topo-message-success alert alert-success mt-5 w-50 ml-auto mr-auto text-center">
                    Votre inscription a bien été validée !
                </div>
            </c:if>
            <h1 class="text-center">Connexion</h1>

            <c:if test="${!empty sessionScope.error}">
                <div class="alert alert-danger w-50 m-auto">
                    <c:out value="${sessionScope.error}" />
                </div>
            </c:if>

            <form method="post" action="/validation_connection" class="w-50 m-auto pt-3">
                <label for="login">Login : </label>
                <input type="text" name="login" id="login" class="form-control" required />
                <label for="password" class="mt-1">Mot de passe : </label>
                <input type="password" name="password" id="password" class="form-control" required />
                <button type="submit" class="mt-3">Se connecter</button>
            </form>
        </div>
    </body>
</html>
