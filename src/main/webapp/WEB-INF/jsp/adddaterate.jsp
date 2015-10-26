<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Add Date Rate</title>
    <jsp:include page="layouts/head.jsp"/>
	
    <script src="https://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
    <script src="js/jquery.caret.min.js"></script>
    <script src="js/jquery.tag-editor.min.js"></script>
        
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/flick/jquery-ui.css"/>
    <link href="/css/jquery.tag-editor.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <h3>Tell everyone how it went</h3>
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                  <div class="panel-heading">
                    <h3 class="panel-title">Rate your date</h3>
                  </div>
                  <div class="panel-body">
                    <springForm:form commandName="dateRateDTO" id="AddDateRateForm" class="form-horizontal" method="POST" action="/daterate">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Who are you rating?</label>
                            <div class="col-sm-8">
                                <input type="text" name="dateUsername" class="form-control input-xs" value="${dateRateDTO.dateUsername}"/>
                                <span class="text-muted">Use an alias or an online dating username. Do not use real names.</span>
                                <springForm:errors path="dateUsername" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Where did you meet?</label>
                            <div class="col-sm-8">
                                <springForm:select path="predefinedDatingSite" class="form-control input-xs" id="DatingSiteOptions">
                                    <springForm:options items="${datingSiteOptions}"/>
                                </springForm:select>
                                <springForm:errors path="predefinedDatingSite" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group" id="DatingSiteDiv" <c:if test="${!showPredefinedDatingSiteOther}">style="display:none"</c:if> >
                            <label class="col-sm-3 control-label">Dating site:</label>
                            <div class="col-sm-8">
                                <input type="text" name="userDefinedDatingSite" id="DatingSite" class="form-control"/>
                                <springForm:errors path="userDefinedDatingSite" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Give them a score</label>
                            <div class="col-sm-8">
                                <springForm:select path="score" class="form-control input-xs" name="score" id="score">
                                    <springForm:options items="${scoreOptions}"/>
                                </springForm:select>
                                <springForm:errors path="score" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">How did it go?</label>
                            <div class="col-sm-8">
                                <textarea name="description" class="form-control input-xs" required>${dateRateDTO.description}</textarea>
                                <springForm:errors path="description" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">#Hashtags</label>
                            <div class="col-sm-8">
                                <textarea id="hashtags" name="hashtags" class="form-control"></textarea>
                                <p class="small text-muted"><i><b>Example:</b> #NeverAgain #FunTime #Boring</i></p>
                                <springForm:errors path="hashtags" cssClass="text-danger" element="div"/>
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
                                <input type="submit" value="Rate!" class="btn btn-primary"/>
                            </div>
                        </div>
                        <input type="hidden" name="recaptcha" id="recaptcha" />
                    </springForm:form>
                  </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/add_date_rate.js"></script>
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