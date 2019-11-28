<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 28/11/2019
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="fr">
    <head>
        <%@ include file="header.jsp" %>
        <title>Le site est officiel !</title>
    </head>
    <body>
        <%@ include file="/jsp/menu.jsp" %>
        <div class="content">
            <h1>Modifier un commentaire</h1>

            <div class="form-comment w-75 m-auto">
                <form action="/update_comment?id=${site.getId()}" method="post" >
                    <label for="author">Auteur<span class="input-required">*</span></label>
                    <br/>
                    <input type="text" name="author" id="author" class="for-control mb-3" value="${comment.getAuthor()}" required />
                    <br />
                    <label for="author">Commentaire<span class="input-required">*</span></label>
                    <textarea name="comment" id="comment" class="form-control">${comment.getComment()}</textarea>
                    <button type="submit" class="mt-3">Envoyer le commentaire</button>
                </form>
            </div>
        </div>
    </body>
</html>
