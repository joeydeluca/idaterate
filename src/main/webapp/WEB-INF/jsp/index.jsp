<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="http://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <h1>Save the world - Rate your date!</h1>
        <hr/>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                        <h3 class="panel-title">Have you been rated?</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" action="/search">
                                <p>Enter your online dating username and find out if you have been date rated!</p>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Username: </label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="username"/>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="submit" class="btn btn-default">Search</button>
                                    </div>
                                </div>
                              </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-7">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h3 class="panel-title">Rate your date</h3>
                      </div>
                      <div class="panel-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Who are you rating?</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control input-xs"/>
                                    <span class="text-muted">Use an alias or an online dating username. Do not use real names.</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Where did you meet?</label>
                                <div class="col-sm-8">
                                     <select class="form-control input-xs"><option>Offline</option><option>Match.com</option><option>10</option></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Dating site:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Give them a score</label>
                                <div class="col-sm-8">
                                     <select class="form-control input-xs"><option>1</option><option>5</option><option>10</option></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">How did it go?</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control input-xs"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12 text-right">
                                    <input type="button" value="Rate!" class="btn btn-primary"/>
                                </div>
                            </div>
                        </form>
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
            <div class="row">
                <div class="col-md-12">
                    <h1>Latest Date Rates</h1>
                    <hr/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                <c:forEach var="dateRate" items="${worstDateRateList}">
                    <tags:dateRateItem dateRate="${dateRate}"/>
                </c:forEach>
                </div>
                <div class="col-md-6">
                <c:forEach var="dateRate" items="${bestDateRateList}">
                    <tags:dateRateItem dateRate="${dateRate}"/>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>
</html>