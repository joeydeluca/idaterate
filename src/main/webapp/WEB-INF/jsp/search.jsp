<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
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

        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Search Criteria</h3>
                  </div>
                  <div class="panel-body">
                  <springForm:form commandName="SearchCriteriaDTO" id="SearchCriteriaForm" method="GET" action="/search">
                        <div class="row">
                            <div class="col-md-4 form-group">
                                Dating Site:
                                <springForm:select path="selectedDatingSite" class="form-control input-xs" id="DatingSiteOptions">
                                    <springForm:options items="${datingSiteOptions}"/>
                                </springForm:select>
                            </div>
                            <div class="col-md-4 form-group">
                                HashTags: <input type="text" class="form-control" name="hashtags" value="${SearchCriteriaDTO.hashtags}"/>
                            </div>
                            <div class="col-md-4 form-group">
                                Username: <input type="text" class="form-control" name="username" value="${SearchCriteriaDTO.username}">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12"><input type="submit" class="btn btn-primary" value="Search"/></div>
                        </div>
                        <input type="hidden" name="sortingOption" id="sortingOption" value="${SearchCriteriaDTO.sortingOption}"/>
                  </springForm:form>
                  </div>
                </div>
            </div>
        </div>

        <div class="dropdown" style="float:right">
          <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${sortingOptionDisplay}
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="javascript:setSort('best');">Show Best Dates First</a></li>
            <li><a href="javascript:setSort('worst');">Show Worst Dates First</a></li>
            <li><a href="javascript:setSort('');">Standard</a></li>
          </ul>
        </div>
        <div style="clear:both"></div>
        <hr style="border-color: white;margin-top:1px"/>

        <c:if test="${empty dateRateList}"><p>No records found for search criteria.</p></c:if>

        <div class="row">
            <c:forEach var="dateRate" items="${dateRateList}">
                <div class="col-md-6">
                    <tags:dateRateItem dateRate="${dateRate}"/>
                </div>
            </c:forEach>
        </div>

        <a href="${nextPage}">Next</a>
    </div>

    <script>
        function setSort(sort) {
            $('#sortingOption').val(sort);
            $('#SearchCriteriaForm').submit();
        }
    </script>
</body>
</html>