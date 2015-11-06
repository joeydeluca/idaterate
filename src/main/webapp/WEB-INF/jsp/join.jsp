<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Join Free and Rate your Dates</title>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/flick/jquery-ui.css"/>
    <link href="/css/jquery.tag-editor.css" rel="stylesheet" type="text/css"/>

    <jsp:include page="layouts/head.jsp"/>
	
    <script src="https://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
    <script src="js/jquery.caret.min.js"></script>
    <script src="js/jquery.tag-editor.min.js"></script>

</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                  <div class="panel-heading">
                    <h3 class="panel-title">Create your account - FREE</h3>
                  </div>
                  <div class="panel-body">
                    <springForm:form commandName="joinFormDTO" id="JoinForm" class="form-horizontal" method="POST" action="/registration">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-8">
                                <input type="text" name="email" class="form-control input-xs" value="${joinFormDTO.email}"/>
                                <span class="text-muted">We promise not to spam you!</span>
                                <springForm:errors path="email" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Username</label>
                            <div class="col-sm-8">
                                <input type="text" name="username" class="form-control input-xs" value="${joinFormDTO.username}"/>
                                <span class="text-muted">Use an alias or an online dating username.</span>
                                <springForm:errors path="username" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-8">
                                <input type="text" name="password" class="form-control input-xs" value="${joinFormDTO.password}"/>
                                <span class="text-muted">Don't forget this. You will need it to login.</span>
                                <springForm:errors path="password" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">City</label>
                            <div class="col-sm-8">
                                <input type="text" name="city" class="form-control input-xs" value="${joinFormDTO.city}"/>
                                <span class="text-muted">Where are you from?</span>
                                <springForm:errors path="city" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                              <div class="checkbox">
                                <label>
                                  <input type="checkbox" name="agreeToEmail"> I agree to email notifications
                                </label>
                                <springForm:errors path="agreeToEmail" cssClass="text-danger" element="div"/>
                              </div>
                            </div>
                        </div>
                        <c:if test="${!empty recaptcha_site_key}">
                            <div class="form-group">
                                <div class="col-md-offset-3 col-sm-8">
                                    <div id="recaptcha_element"></div>
                                    <springForm:errors path="recaptcha" cssClass="text-danger" element="div"/>
                                </div>
                            </div>
                        </c:if>
                        <hr/>
                        <div class="form-group">
                            <div class="col-xs-12 text-right">
                                <input type="submit" value="Join" class="btn btn-primary"/>
                            </div>
                        </div>
                        <input type="hidden" name="recaptcha" id="recaptcha" />
                    </springForm:form>
                  </div>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${!empty recaptcha_site_key}">
    <script src='https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit'></script>
    <script>
      var onloadCallback = function() {
        grecaptcha.render('recaptcha_element', {
          'sitekey' : '${recaptcha_site_key}',
          'callback' : function(response) {
              document.getElementById('recaptcha').value = response;
          },
          'theme' : 'light'
        });

      };
    </script>
    </c:if>
</body>
</html>