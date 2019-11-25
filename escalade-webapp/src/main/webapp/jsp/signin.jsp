<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 13/11/2019
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">

    <head>
        <%@ include file="header.jsp" %>
        <title>S'inscrire - Les amis de l'escalade</title>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <div class="content">
            <h1 class="text-center">Inscription</h1>

            <form method="post" action="/validation_inscription" class="w-50 m-auto">
                <div class="form-group">
                    <label for="name">Nom<span class="input-required">*</span></label>
                    <input type="text" name="name" id="name" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="firstname">Prénom<span class="input-required">*</span></label>
                    <input type="text" name="firstname" id="firstname" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe<span class="input-required">*</span></label>
                    <input type="password" name="password" id="password" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="email">Email<span class="input-required">*</span></label>
                    <input type="email" name="email" id="email" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="address">Adresse<span class="input-required">*</span></label>
                    <input type="text" name="address" id="address" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="postal_code">Code postal<span class="input-required">*</span></label>
                    <input type="text" name="postal_code" id="postal_code" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="town">Ville<span class="input-required">*</span></label>
                    <input type="text" name="town" id="town" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="phone_number">Téléphone<span class="input-required"></span></label>
                    <input type="tel" name="phone_number" id="phone_number" class="form-control" />
                </div>
                <button type="submit" class="mb-5">Terminer l'inscription</button>
            </form>
        </div>
    </body>
</html>
