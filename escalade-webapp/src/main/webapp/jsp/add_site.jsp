<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 27/11/2019
  Time: 10:19
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
            <h1 class="text-center">Ajouter un site</h1>

            <form method="post" action="/insert_site" class="w-50 m-auto">
                <div class="form-group">
                    <label for="name">Nom du site<span class="input-required">*</span></label>
                    <input type="text" name="name" id="name" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="description">Description<span class="input-required">*</span></label><br />
                    <textarea name="description" id="description" required></textarea>
                </div>
                <div class="form-group">
                    <label for="length">Hauteur (en mètres)<span class="input-required">*</span></label>
                    <input type="number" name="length" id="length" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="place">Lieu<span class="input-required">*</span></label>
                    <input type="text" name="place" id="place" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="grade">Cotation<span class="input-required">*</span></label>
                    <input type="text" name="grade" id="grade" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="numberOfWays">Nombre de voies<span class="input-required">*</span></label>
                    <input type="number" name="numberOfWays" id="numberOfWays" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="numberOfSectors">Indiquez le nombre de secteurs<span class="input-required">*</span></label>
                    <input type="number" name="numberOfSectors" id="numberOfSectors" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="sector1">Les principaux secteurs (au moins 1)<span class="input-required">*</span></label>
                    <input type="text" name="sector1" id="sector1" class="form-control" required />
                </div>
                <div class="form-group">
                    <input type="text" name="sector2" id="sector2" class="form-control" />
                </div>
                <div class="form-group">
                    <input type="text" name="sector3" id="sector3" class="form-control" />
                </div>
                <div class="form-group">
                    <input type="text" name="sector4" id="sector4" class="form-control" />
                </div>
                <div class="form-group">
                    <input type="text" name="sector5" id="sector5" class="form-control" />
                </div>
                <button type="submit" class="mb-5">Terminer</button>
            </form>
        </div>
    </body>
</html>
