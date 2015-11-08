<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | Login</title>
    <jsp:include page="layouts/head.jsp"/>

    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="iDateRate" />
    <meta property="og:description"   content="${dateRate.description}" />

</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <tags:dateRateItem dateRate="${dateRate}"/>
    </div>
</body>
</html>