<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 02/12/2019
  Time: 08:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
    <html lang="fr">
    <head>
        <%@ include file="header.jsp" %>
        <title>Liste des topos disponibles</title>
    </head>
    <body>
    <%@ include file="/jsp/menu.jsp" %>
        <div class="content">
            <h1 class="text-center">Tous les topos disponibles</h1>

            <c:set var="count" value="0" scope="page" />
            <c:set var="isUsed" value="false"/>
            <c:choose>
                <c:when test="${!empty availableTopos}">
                    <c:forEach var="i" begin="0" end="${fn:length(availableTopos) - 1}" step="1">

                        <c:set var="isUsed" value="false"/>
                        <c:if test="${!empty awaitingDataTopos}">
                            <c:forEach var="j" begin="0" end="${fn:length(awaitingDataTopos) - 1}" step="1">
                                <c:if test="${awaitingDataTopos[j].getTopoId().equals(availableTopos[i].getId())}">
                                    <c:set var="isUsed" value="true"/>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <c:if test="${count % 3 == 0}">
                            <div class="container d-flex flex-column flex-lg-row align-content-around">
                        </c:if>
                        <c:if test="${isUsed.equals(\"false\")}">
                            <div class="column-table-link">
                                <table class="list-sites table">
                                    <tr>
                                        <th scope="col">
                                            Nom
                                        </th>
                                        <td scope="col">
                                            <c:out value="${availableTopos[i].getName()}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="col">
                                            Description
                                        </th>
                                        <td scope="col">
                                            <c:out value="${availableTopos[i].getDescription()}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="col">
                                            Lieu
                                        </th>
                                        <td scope="col">
                                            <c:out value="${availableTopos[i].getPlace()}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="col">
                                            Date de parution
                                        </th>
                                        <td scope="col">
                                            <c:out value="${availableTopos[i].getDate()}" />
                                        </td>
                                    </tr>
                                </table>
                                <p><a href="/reserve?id=${availableTopos[i].getId()}&amp;memberId=${availableTopos[i].getMemberId()}" onclick='return confirm("Êtes-vous sûr de réserver ce topo ?")'>Demander à réserver ce topo</a></p>
                            </div>
                            <c:set var="count" value="${count + 1}" />
                        </c:if>
                        <c:if test="${count % 3 == 0}" >
                            </div>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p class="text-center">Aucun topo n'est disponible.</p>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
