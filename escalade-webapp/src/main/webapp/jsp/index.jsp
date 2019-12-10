<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 12/11/2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="fr">
    <head>
        <%@ include file="header.jsp" %>
        <title>Accueil - Les amis de l'escalade</title>
    </head>
    <body>
        <%@ include file="/jsp/menu.jsp" %>
        <div class="content text-center">
            <c:if test="${logout != null}">
                <div class="topo-message-success alert alert-success mt-5 w-50 ml-auto mr-auto text-center">
                    Vous êtes bien déconnecté.
                </div>
            </c:if>
            <h1>Bienvenue</h1>
            <p>Bonjour et bienvenue sur le site des Amis de l'escalade !</p>
            <p>La porte est ouverte à tous les passionnés d'escalade de France ! Venez découvrir où vous pouvez relever des défis, armés de vos points d'ancrage.</p>
            <p>Vous pouvez retrouver <a href="/sites">les différents sites</a> que nous proposons. Si vous êtes intéressés et que vous souhaitez rejoindre notre communauté de grimpeurs, <a href="/login">inscrivez-vous</a> !</p>
            <p>Bonne visite !</p>
            <p class="image-home"><img src="./img/accueil.jpg" alt="Homme levant les bras au bord d'une falaise avec un point de vue sur une chaîne montagneuse" /></p>
        </div>
    </body>
</html>
