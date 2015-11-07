<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">iDateRate</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/daterate">Rate your Date</a></li>
                <li><a href="/search">View Ratings</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty authenticatedUsername}"><li><a href="/registration">Create an Account</a></li></c:if>
                <c:if test="${empty authenticatedUsername}"><li><a href="/login">Login</a></li></c:if>
                <c:if test="${!empty authenticatedUsername}"><li><a href="/logout">Logout</a></li></c:if>
                <li><a href="/contact">Contact Us</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>