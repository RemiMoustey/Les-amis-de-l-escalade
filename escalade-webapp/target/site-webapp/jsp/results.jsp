<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 25/11/2019
  Time: 08:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="fr">
    <head>
        <%@ include file="header.jsp" %>
        <title>Résultats de la recherche</title>
    </head>
    <body>
        <%@ include file="/jsp/menu.jsp" %>
        <div class="content">
            <p class="results-search text-center">Résultats de la recherche pour "<c:out value="${search}"/>" :</p>
            <c:set var="count" value="0" scope="page" />
            <c:if test="${fn:length(sites) > 0}">
                <c:forEach var="i" begin="0" end="${fn:length(sites) - 1}" step="1">
                <c:if test="${count % 3 == 0}">
                    <div class="container d-flex flex-column flex-lg-row align-content-around">
                </c:if>
                <table class="list-sites table m-3">
                    <tr>
                        <th scope="col">
                            Nom
                        </th>
                        <td scope="col">
                            <c:out value="${sites[i].getName()}" />
                        </td>
                    </tr>
                    <tr>
                        <th scope="col">
                            Secteurs
                        </th>
                        <td scope="col">
                            <ul>
                                <c:forTokens var="sector" items="${sites[i].getSectors()}" delims=",">
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
                            <c:out value="${sites[i].getNumberOfSectors()}" />
                        </td>
                    </tr>
                    <tr>
                        <th scope="col">
                            Hauteur
                        </th>
                        <td scope="col">
                            <c:out value="${sites[i].getLength()}" />
                        </td>
                    </tr>
                    <tr>
                        <th scope="col">
                            Lieu
                        </th>
                        <td scope="col">
                            <c:out value="${sites[i].getPlace()}" />
                        </td>
                    </tr>
                    <tr>
                        <th scope="col">
                            Cotation
                        </th>
                        <td scope="col">
                            <c:out value="${sites[i].getGrade()}" />
                        </td>
                    </tr>
                    <tr>
                        <th scope="col">
                            Nombre de voies
                        </th>
                        <td scope="col">
                            <c:out value="${sites[i].getNumberOfWays()}" />
                        </td>
                    </tr>
                </table>
                <c:set var="count" value="${count + 1}" />
                <c:if test="${count % 3 == 0}" >
                    </div>
                </c:if>
                </c:forEach>
            </c:if>
        </div>
    </body>
</html>
