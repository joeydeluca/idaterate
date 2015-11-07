<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Login</title>
    <jsp:include page="layouts/head.jsp"/>
</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <div class="panel panel-primary">
                  <div class="panel-heading">
                    <h3 class="panel-title">Login</h3>
                  </div>
                  <div class="panel-body">
                    <springForm:form commandName="loginFormDTO" id="LoginForm" class="form-horizontal" method="POST" action="/login">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-8">
                                <input type="email" name="email" class="form-control input-xs" value="${loginFormDTO.email}"/>
                                <springForm:errors path="email" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-8">
                                <input type="password" name="password" class="form-control input-xs" value="${loginFormDTO.password}"/>
                                <springForm:errors path="password" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <c:if test="${!empty error}">
                            <div class="text-center">
                                <div class="alert alert-danger" role="alert">
                                  ${error}
                                </div>
                            </div>
                        </c:if>
                        <hr/>
                        <div class="form-group">
                            <div class="col-xs-12 text-right">
                                <input type="submit" value="Login" class="btn btn-primary"/>
                            </div>
                        </div>
                    </springForm:form>
                  </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>