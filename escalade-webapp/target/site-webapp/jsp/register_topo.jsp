<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 29/11/2019
  Time: 08:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="fr">
    <head>
        <%@ include file="header.jsp" %>
        <title>Commentaire posté</title>
    </head>
    <body>
        <%@ include file="/jsp/menu.jsp" %>
        <div class="content">
            <form method="post" action="/insert_topo" class="w-50 m-auto">
                <div class="form-group">
                    <label for="name">Nom du topo<span class="input-required">*</span></label>
                    <input type="text" name="name" id="name" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="description">Description<span class="input-required">*</span></label>
                    <textarea name="description" id="description" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label for="place">Lieu<span class="input-required">*</span></label>
                    <input type="text" name="place" id="place" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="date">Date de parution<span class="input-required">*</span></label>
                    <input type="date" name="date" id="date" class="form-control" required />
                </div>
                <button type="submit" class="mb-5">Enregistrer le topo</button>
            </form>
        </div>
    </body>
</html>
