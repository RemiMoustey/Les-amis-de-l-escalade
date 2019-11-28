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
            <p class="w-75 text-justify ml-auto mr-auto mb-3"><c:out value="${site.getDescription()}" /></p>
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
                                <li><c:out value="${sector}" /></li>
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
                <tr>
                    <th scope="col">
                        Statut
                    </th>
                    <td scope="col">
                        <c:choose>
                            <c:when test="${site.getOfficial()}">
                                <span class="green">Site officiel Les Amis de l'escalade</span
                            </c:when>
                            <c:otherwise>
                                <span class="red">Site non officiel</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
            <c:choose>
                <c:when test="${sessionScope.adminConnected && !site.getOfficial()}">
                    <p class="text-center"><a class="link-official green" href="/make_official?id=${site.getId()}">Désigner ce site comme site officiel Les Amis de l'Escalade</a></p>
                </c:when>
                <c:when test="${sessionScope.adminConnected && site.getOfficial()}">
                    <p class="text-center"><a class="link-unofficial red" href="/make_unofficial?id=${site.getId()}">Désigner ce site comme site non officiel Les Amis de l'Escalade</a></p>
                </c:when>
            </c:choose>
            <c:if test="${!empty sessionScope.login}">
                <h2 class="text-center">Commentaires</h2>
                <div class="comments">
                    <c:if test="${!empty allComments}">
                        <c:forEach var="i" begin="0" end="${fn:length(allComments) - 1}" step="1">
                            <div class="one-comment w-75 m-auto pb-5">
                                <h3><c:out value="${allComments[i].getAuthor()}" /></h3>
                                <p><c:out value="${allComments[i].getComment()}" /></p>
                                <c:if test="${sessionScope.adminConnected}">
                                    <div class="admin-links">
                                        <a href="/modify_comment?id=${allComments[i].getId()}">Modifier</a><br />
                                        <a href="/delete_comment?id=${allComments[i].getId()}" onclick='return confirm("Êtes-vous sûr de supprimer ce commentaire ?")'>Supprimer</a>
                                    </div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty allComments}">
                        <p class="text-center pb-5">Pas de commentaires</p>
                    </c:if>
                </div>
                <h2 class="text-center">Ajouter un commentaire</h2>
                <div class="form-comment w-75 m-auto">
                    <form action="/insert_comment?id=${site.getId()}" method="post" >
                        <label for="author">Auteur<span class="input-required">*</span></label>
                        <br/>
                        <input type="text" name="author" id="author" class="for-control mb-3" required />
                        <br />
                        <label for="author">Commentaire<span class="input-required">*</span></label>
                        <textarea name="comment" id="comment" class="form-control"></textarea>
                        <button type="submit" class="mt-3">Envoyer le commentaire</button>
                    </form>
                </div>
            </c:if>
        </div>
    </body>
</html>
