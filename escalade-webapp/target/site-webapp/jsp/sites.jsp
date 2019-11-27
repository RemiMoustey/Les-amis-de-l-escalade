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
        <div class="content">
            <h1 class="text-center mt-3">Les sites d'escalade</h1>
            <c:if test="${!empty sessionScope.login}">
                <p class="text-center"><a href="/add_site">Ajouter un site</a></p>
            </c:if>
            <form method="post" action="/results" class="form-search">
                <label for="search">Rechercher un site</label>
                <input type="text" name="search" id="search" />
                <div>
                    <input type="radio" id="name" name="field" value="name" />
                    <label for="name">Nom du site</label><br />
                    <input type="radio" id="sectors" name="field" value="description" />
                    <label for="sectors">Secteurs</label><br />
                    <input type="radio" id="number_of_sectors" name="field" value="number_of_sectors" />
                    <label for="number_of_sectors">Nombre de secteurs</label><br />
                    <input type="radio" id="length" name="field" value="length" />
                    <label for="length">Hauteur</label><br />
                    <input type="radio" id="place" name="field" value="place" />
                    <label for="place">Lieu</label><br />
                    <input type="radio" id="grade" name="field" value="grade" />
                    <label for="grade">Cotation</label><br />
                    <input type="radio" id="number_of_ways" name="field" value="number_of_ways" />
                    <label for="number_of_ways">Nombre de voies</label>
                </div>
                <input type="submit" value="Rechercher" />
            </form>
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="i" begin="0" end="${fn:length(allSites) - 1}" step="1">
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
                                <c:out value="${allSites[i].getNumberOfWays()}" />
                            </td>
                        </tr>
                    </table>
                    <p><a href="/one_site?site=${allSites[i].getName()}">En savoir plus</a></p>
                </div>
                <c:set var="count" value="${count + 1}" />
                <c:if test="${count % 3 == 0}" >
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </body>
</html>
