<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Success</title>
    <jsp:include page="layouts/head.jsp"/>

</head>
<body>
    <jsp:include page="layouts/nav.jsp" />
    <div class="container">
        <div class="row">
            <div class="col-md-12" style="margin-top:20px">
                <div class="panel panel-info">
                    <div class="panel-heading">
                    <h3 class="panel-title">Success</h3>
                    </div>
                    <div class="panel-body">
                        <p>Your account successfully has been created!</p>
                        <hr/>
                        <input type="button" class="btn btn-info" value="Rate a date" onclick="javacript:window.location = '/daterate';" />
                        <input type="button" class="btn btn-default" value="Manage my profile"  onclick="javacript:window.location = '/';"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>