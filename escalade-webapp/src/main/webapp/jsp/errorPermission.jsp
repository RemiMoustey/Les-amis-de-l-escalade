<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 09/12/2019
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="fr">
<head>
    <%@ include file="header.jsp" %>
    <title>Accès refusé</title>
</head>
<body>
<%@ include file="/jsp/menu.jsp" %>
<div class="content">
    <div class="alert alert-danger mt-5 w-50 ml-auto mr-auto text-center">
        Vous n'avez pas la permission d'accéder à cette page.
    </div>
</div>
</body>
</html>
