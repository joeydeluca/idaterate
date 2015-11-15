<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Rate Your Dates</title>
    <jsp:include page="layouts/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="css/landing.css">
</head>
<body>

    <jsp:include page="layouts/nav.jsp"/>
    <div class="header">
        <div class="mainContentWrapper">
            <div class="mainContentBG"></div>
            <div class="mainContent">
                <div class="logo"><center><img src="images/date_logo.png" class="img-responsive" /></center></div>
                <div><center><a href="/daterate"><img src="images/top_content_start_btn.png" class="img-responsive" /></a></center></div>
                <div class="mainContentText">Been Rated?</div>
                <div class="mainContentSubText">Let's find out...</div>
            </div>
        </div>
        <div class="arrow">
            <span class="glyphicon glyphicon-arrow-down"/>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
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
                                    <button type="submit" class="btn btn-primary">Search</button>
                                </div>
                            </div>
                          </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-info">
                    <div class="panel-heading">
                    <h3 class="panel-title">What is iDateRate?</h3>
                    </div>
                    <div class="panel-body">
                        <p><strong>iDateRate.com</strong> enables you to rate your dates and share your reviews with others.
                        Have an upcoming date? Find out if you are meeting a creep!</p>
                        <div
                          class="fb-like"
                          data-share="false"
                          data-width="200"
                          data-show-faces="false">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-info">
                  <div class="panel-heading">
                    <h3 class="panel-title">Why iDateRate?</h3>
                  </div>
                  <div class="panel-body">
                    <p>
                    Dating can be dangerous game. Protect yourself from terrible dates by reviewing your potential partner.
                   </p>
                  </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
            <h3>Worst Date Rates</h3>
            <c:forEach var="dateRate" items="${worstDateRateList}">
                <tags:dateRateItem dateRate="${dateRate}"/>
            </c:forEach>
            </div>
            <div class="col-md-6">
            <h3>Best Date Rates</h3>
            <c:forEach var="dateRate" items="${bestDateRateList}">
                <tags:dateRateItem dateRate="${dateRate}"/>
            </c:forEach>
            </div>
        </div>
    </div>



</body>
</html>