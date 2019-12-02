<%--
  Created by IntelliJ IDEA.
  User: Rémi Moustey
  Date: 13/11/2019
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>

<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
    <ul class="navbar-nav d-flex align-items-center m-auto">
        <li class=nav-item>
            <a class="navbar-brand" href="#">
                <img src="../img/logo.png" alt="Logo de l'association Les amis de l'escalade" />
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Accueil</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/sites">Sites d'escalade</a>
        </li>
        <c:if test="${empty sessionScope.login}">
            <li class="nav-item">
                <a class="nav-link" href="/signin">S'inscrire</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Se connecter</a>
            </li>
        </c:if>
        <c:if test="${!empty sessionScope.login}">
            <li class="nav-item">
                <a class="nav-link" href="/dashboard?id=<c:out value="${sessionScope.memberId}" />">Espace personnel</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/topos?id=<c:out value="${sessionScope.memberId}" />">Topos disponibles</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Se déconnecter</a>
            </li>
        </c:if>
    </ul>
</nav>
