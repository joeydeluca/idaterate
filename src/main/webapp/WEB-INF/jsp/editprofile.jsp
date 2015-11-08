<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Profile</title>
    <jsp:include page="layouts/head.jsp"/>
</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="panel panel-primary">
                  <div class="panel-heading">
                    <h3 class="panel-title">Profile Photo</h3>
                  </div>
                  <div class="panel-body">
                    <img src="/photo" class="img-thumbnail">
                  </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="panel panel-primary">
                  <div class="panel-heading">
                    <h3 class="panel-title">My Profile</h3>
                  </div>
                  <div class="panel-body">
                   Coming Soon!
                  </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>