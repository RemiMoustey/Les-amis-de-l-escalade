<%@ page import="java.util.Iterator" %>
<%@ page import="org.projet6.escalade.model.bean.site.Site" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 13/11/2019
  Time: 08:37
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
        <h1 class="text-center mt-3">Les sites d'escalade</h1>
        <c:set var="count" value="0" scope="page" />
        <c:forEach var="i" begin="0" end="${fn:length(allSites) - 1}" step="1">
            <c:if test="${count % 3 == 0}">
                <div class="container d-flex flex-column flex-lg-row align-content-around">
            </c:if>
            <table class="list-sites table m-3">
                <tr>
                    <th scope="col">
                        Nom
                    </th>
                    <td scope="col">
                        <c:out value="${allSites[i].getName()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Secteurs
                    </th>
                    <td scope="col">
                        <ul>
                            <c:forTokens var="sector" items="${allSites[i].getSectors()}" delims=",">
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
                        <c:out value="${allSites[i].getNumberOfSectors()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Hauteur
                    </th>
                    <td scope="col">
                        <c:out value="${allSites[i].getLength()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Lieu
                    </th>
                    <td scope="col">
                        <c:out value="${allSites[i].getPlace()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Cotation
                    </th>
                    <td scope="col">
                        <c:out value="${allSites[i].getGrade()}" />
                    </td>
                </tr>
                <tr>
                    <th scope="col">
                        Nombre de voies
                    </th>
                    <td scope="col">
                        <c:out value="${allSites[i].getWay()}" />
                    </td>
                </tr>
            </table>
            <c:set var="count" value="${count + 1}" />
            <c:if test="${count % 3 == 0}" >
                </div>
            </c:if>
        </c:forEach>
    </body>
</html>
