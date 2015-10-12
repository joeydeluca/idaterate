<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Add Date Rate</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="http://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	
    <script src="https://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
    <script src="js/jquery.caret.min.js"></script>
    <script src="js/jquery.tag-editor.min.js"></script>
        
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/flick/jquery-ui.css"/>
    <link href="/css/jquery.tag-editor.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <h1>Add Date Rate</h1>
        <hr/>
        <div class="container">
        	<div class="row">
                <div class="col-md-7">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h3 class="panel-title">Rate your date</h3>
                      </div>
                      <div class="panel-body">
                        <springForm:form commandName="dateRateDTO" id="AddDateRateForm" class="form-horizontal" method="POST" action="/daterate">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Who are you rating?</label>
                                <div class="col-sm-8">
                                    <input type="text" name="dateUsername" class="form-control input-xs" value="${dateRateDTO.dateUsername}"/>
                                    <span class="text-muted">Use an alias or an online dating username. Do not use real names.</span>
                                    <springForm:errors path="dateUsername" cssClass="text-danger" element="div"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Where did you meet?</label>
                                <div class="col-sm-8">
                                    <springForm:select path="predefinedDatingSite" class="form-control input-xs" id="DatingSiteOptions">
                                        <springForm:options items="${datingSiteOptions}"/>
                                    </springForm:select>
                                    <springForm:errors path="predefinedDatingSite" cssClass="text-danger" element="div"/>
                                </div>
                            </div>
                            <div class="form-group" id="DatingSiteDiv" style="display:none">
                                <label class="col-sm-4 control-label">Dating site:</label>
                                <div class="col-sm-8">
                                    <input type="text" name="userDefinedDatingSite" id="DatingSite" class="form-control"/>
                                    <springForm:errors path="userDefinedDatingSite" cssClass="text-danger" element="div"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Give them a score</label>
                                <div class="col-sm-8">
                                    <springForm:select path="score" class="form-control input-xs" name="score" id="score">
                                        <springForm:options items="${scoreOptions}"/>
                                    </springForm:select>
                                    <springForm:errors path="score" cssClass="text-danger" element="div"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">How did it go?</label>
                                <div class="col-sm-8">
                                    <textarea name="description" class="form-control input-xs" required>${dateRateDTO.description}</textarea>
                                    <springForm:errors path="description" cssClass="text-danger" element="div"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">#Hashtags</label>
                                <div class="col-sm-8">
                                    <textarea id="demo1" name="hashtags"></textarea>
                                    <p class="small text-muted"><i><b>Example:</b> #NeverAgain #FunTime #Boring</i></p>
                                    <springForm:errors path="hashtags" cssClass="text-danger" element="div"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12 text-right">
                                    <input type="submit" value="Rate!" class="btn btn-primary"/>
                                </div>
                            </div>
                        </springForm:form>
                      </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                        <h3 class="panel-title">What is Date Rate?</h3>
                        </div>
                        <div class="panel-body">
                            <p>iDateRate.com enables you to rate your dates and share your reviews with others. Had a bad date? Protect the world and leave a date rate. Users can search for date reviews before actually going on a date!</p>
                        </div>
                    </div>
                    <div class="panel panel-info">
                      <div class="panel-heading">
                        <h3 class="panel-title">Average Date Rate Score</h3>
                      </div>
                      <div class="panel-body">
                        This weeks average Date Rate score is...
                        <hr/>
                        <div class="text-center"><h2 class="text-primary">4.3</h2></div>
                      </div>
                    </div>
                </div>
            </div> 
        </div>
    </div>
    <script>
    $('#demo1').tagEditor({
        delimiter: ', ', /* space and comma */
        placeholder: '#'
    });
    </script>
    <script src="js/add_date_rate.js"></script>
</body>
</html>