<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 09/12/2019
  Time: 16:46
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
        Le topo et le propriétaire du topo ne correspondent pas ou le topo n'est pas disponible.
    </div>
</div>
</body>
</html>
