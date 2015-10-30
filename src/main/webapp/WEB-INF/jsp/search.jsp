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
                            <div class="col-xs-12">
                                <input type="button" class="btn btn-primary" value="Search" onclick="javascript:search();"/>
                            </div>
                        </div>
                        <input type="hidden" name="sortingOption" id="sortingOption" value="${SearchCriteriaDTO.sortingOption}"/>
                        <input type="hidden" name="page" id="page" value="${SearchCriteriaDTO.page}"/>
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

        <c:if test="${!empty dateRateList}">
        <div class="row">
            <div class="col-md-12 text-center">
                <nav>
                    <ul class="pagination pagination-lg">
                        <li <c:if test="${currentPage == 0}">class="disabled"</c:if>><a <c:if test="${currentPage > 0}">href="javascript:setPage(${currentPage-1});" </c:if> aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                        <c:forEach var="i" begin="0" end="${totalPages - 1}">
                            <li <c:if test="${i == currentPage}">class="active"</c:if>><a href="javascript:setPage(${i});">${i+1} </a></li>
                        </c:forEach>
                        <li <c:if test="${currentPage >= totalPages}">class="disabled"</c:if>><a  <c:if test="${currentPage < totalPages}"> href="javascript:setPage(${currentPage+1});" </c:if> aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                    </ul>
                </nav>
            </div>
        </div>
        </c:if>
    </div>

    <script>
        function search() {
            $('#page').val(0);
            $('#SearchCriteriaForm').submit();
        }
        function setSort(sort) {
            $('#sortingOption').val(sort);
            $('#SearchCriteriaForm').submit();
        }
        function setPage(pageNum) {
            $('#page').val(pageNum);
            $('#SearchCriteriaForm').submit();
        }
    </script>
</body>
</html>