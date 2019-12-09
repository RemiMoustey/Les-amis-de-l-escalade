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
            <c:if test="${addTopo != null}">
                <div class="topo-message-success alert alert-success mt-5 w-50 ml-auto mr-auto text-center">
                    Votre topo a bien été enregistré !
                </div>
            </c:if>
            <c:if test="${addTopo != null}">
                <div class="topo-message-success alert alert-success mt-5 w-50 ml-auto mr-auto text-center">
                    Votre topo a bien été enregistré !
                </div>
            </c:if>
            <h1 class="text-center">Bienvenue dans votre espace personnel, <c:out value="${sessionScope.login}" /></h1>
            <p class="text-center">
                <a href="/register_topo">Enregistrer un topo</a>
            </p>
            <h2 class="text-center">Vos topos</h2>
            <c:set var="count" value="0" scope="page" />
            <div>
                <c:choose>
                    <c:when test="${!empty allTopos}">
                        <c:forEach var="i" begin="0" end="${fn:length(allTopos) - 1}" step="1">
                            <c:if test="${count % 3 == 0}">
                                <div class="container d-flex flex-column flex-lg-row align-content-around">
                            </c:if>
                            <div class="column-table-link">
                                <table class="list-sites table">
                                    <tr>
                                        <th scope="col">
                                            Nom
                                        </th>
                                        <td scope="col">
                                            <c:out value="${allTopos[i].getName()}" />
                                        </td>
                                    </tr>
                                        <th scope="col">
                                            Description
                                        </th>
                                        <td scope="col">
                                            <c:out value="${allTopos[i].getDescription()}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="col">
                                            Lieu
                                        </th>
                                        <td scope="col">
                                            <c:out value="${allTopos[i].getPlace()}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="col">
                                            Date de parution
                                        </th>
                                        <td scope="col">
                                            <c:out value="${allTopos[i].getDate()}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="col">
                                            Statut
                                        </th>
                                        <td scope="col">
                                            <c:choose>
                                                <c:when test="${allTopos[i].getIsAvailable()}">
                                                    <span class="green">Disponible pour un prêt</span
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="red">Non disponible pour un prêt</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <c:set var="count" value="${count + 1}" />
                            <c:if test="${count % 3 == 0}">
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p class="text-center">Vous n'avez aucun topo enregistré.</p>
                    </c:otherwise>
                </c:choose>
                <c:if test="${count % 3 != 0}">
                    </div>
                </c:if>
            <h2 class="text-center">Les demandes de réservation</h2>
            <c:set var="count" value="0" scope="page" />
            <c:choose>
                <c:when test="${!empty awaitingTopos}">
                    <c:forEach var="i" begin="0" end="${fn:length(awaitingTopos) - 1}" step="1">
                        <c:if test="${count % 3 == 0}">
                            <div class="container d-flex flex-column flex-lg-row align-content-around">
                        </c:if>
                        <div class="column-table-link">
                            <table class="list-sites table">
                                <tr>
                                    <th scope="col">
                                        Nom
                                    </th>
                                    <td scope="col">
                                        <c:out value="${awaitingTopos[i].getName()}" />
                                    </td>
                                </tr>
                                <th scope="col">
                                    Description
                                </th>
                                <td scope="col">
                                    <c:out value="${awaitingTopos[i].getDescription()}" />
                                </td>
                                </tr>
                                <tr>
                                    <th scope="col">
                                        Lieu
                                    </th>
                                    <td scope="col">
                                        <c:out value="${awaitingTopos[i].getPlace()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="col">
                                        Date de parution
                                    </th>
                                    <td scope="col">
                                        <c:out value="${awaitingTopos[i].getDate()}" />
                                    </td>
                                </tr>
                                <p>
                                    <c:forEach var="j" begin="0" end="${fn:length(awaitingDataTopos) - 1}" step="1">
                                        <c:if test="${awaitingTopos[i].getId() == awaitingDataTopos[j].getTopoId()}">
                                            <c:forEach var="k" begin="0" end="${fn:length(allMembers) - 1}" step="1">
                                                <c:if test="${awaitingDataTopos[j].getBuyerId() == allMembers[k].getId()}">
                                                    <p>Réservé par <c:out value="${allMembers[k].getLogin()}"/>
                                                        <br />
                                                        <a href="/accept?id=${awaitingTopos[i].getId()}&amp;buyer_id=${allmembers[k].getId()}&amp;member_id=${awaitingDataTopos[j].getMemberId()}" class="green">Accepter</a>
                                                    </p>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                </p>
                            </table>
                        </div>
                        <c:set var="count" value="${count + 1}" />
                        <c:if test="${count % 3 == 0}" >
                            </div>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p class="text-center">Vous n'avez aucune demande de réservation en attente.</p>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
