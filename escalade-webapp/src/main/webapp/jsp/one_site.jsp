<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 27/11/2019
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="fr">
    <head>
        <%@ include file="header.jsp" %>
        <title>Sites d'escalades - Les amis de l'escalade</title>
    </head>
    <body>
        <%@ include file="/jsp/menu.jsp" %>
        <div class="content">
            <p class="w-75 text-justify ml-auto mr-auto mb-3">${site.getDescription()}</p>
            <table class="site-table table w-75 m-auto">
                <tr>
                    <th scope="col">
                        Nom
                    </th>
                    <td scope="col">
                        <c:out value="${site.getName()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Secteurs
                    </th>
                    <td scope="col">
                        <ul>
                            <c:forTokens var="sector" items="${site.getSectors()}" delims=",">
                                <li>${sector}</li>
                            </c:forTokens>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Nombre de secteurs
                    </th>
                    <td scope="col">
                        <c:out value="${site.getNumberOfSectors()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Hauteur
                    </th>
                    <td scope="col">
                        <c:out value="${site.getLength()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Lieu
                    </th>
                    <td scope="col">
                        <c:out value="${site.getPlace()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Cotation
                    </th>
                    <td scope="col">
                        <c:out value="${site.getGrade()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Nombre de voies
                    </th>
                    <td scope="col">
                        <c:out value="${site.getNumberOfWays()}" />
                    </td>
                </tr>
            </table>
            <h2 class="text-center">Commentaires</h2>
        </div>
    </body>
</html>
