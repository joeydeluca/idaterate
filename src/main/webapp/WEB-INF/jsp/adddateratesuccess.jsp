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
    <jsp:include page="layouts/nav.jsp" />
    <div class="container">
        <h1>Success</h1>
        <hr/>
        <div class="container">
        	<div class="row">
                <div class="col-md-12 jumbotron">
                    <p>Your input has been received!</p>
                </div>
            </div> 
            <div class="row">
                <div class="col-md-12">
                    <input type="button" class="btn btn-primary" value="Rate another date" onclick="javacript:window.location = '/daterate';" />
                    <input type="button" class="btn btn-default" value="Finish"  onclick="javacript:window.location = '/';"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>