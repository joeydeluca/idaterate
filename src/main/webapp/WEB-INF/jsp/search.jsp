<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Search Date Ratings</title>
    <jsp:include page="layouts/head.jsp"/>
</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <h1>Search Results</h1>
        <hr/>
        <c:if test="${empty dateRateList}"><p>No records found for search criteria.</p></c:if>
        <c:forEach var="dateRate" items="${dateRateList}">
            <div class="col-md-6">
                <tags:dateRateItem dateRate="${dateRate}"/>
            </div>
        </c:forEach>
    </div>
</body>
</html>