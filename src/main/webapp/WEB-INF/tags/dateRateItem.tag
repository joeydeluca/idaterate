<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="dateRate" required="true" type="com.idaterate.interfaces.dtos.DateRateDisplayItemDTO" %>

<div id="dateRateItem" class="panel panel-default" >
    <div class="media" style="padding:20px;">
      <div class="col-sm-3">
          <a href="/viewdaterate?id=${dateRate.id}">
             <img src="
             <c:choose>
               <c:when test="${dateRate.score <= 5}">
                     http://www.free-emoticons.com/files/emoticons-smileys/6039.png
               </c:when>
               <c:when test="${dateRate.score > 5}">
                   http://www.free-emoticons.com/files/emoticons-smileys/6037.png
               </c:when>
             </c:choose>
             " class="media-object img-responsive hidden-xs"/>
          </a>
      </div>
      <div class="col-sm-9">
        <h4 class="media-heading">${dateRate.dateUsername} <span class="pull-right badge">Score: ${dateRate.score}</span></h4>
          <p class="text-muted"><i>${dateRate.datingSite} | ${dateRate.city}</i></p>
          <p id="dateRateDescription${dateRate.id}">
              ${dateRate.description}
          </p>
          <c:forEach var="hashtag" items="${dateRate.hashtags}">
            <span class="label label-primary">${hashtag}</span>
          </c:forEach>
          <hr/>
          <div class="text-right">
            <button class="btn btn-info btn-xs" onclick="share('${dateRate.id}','${dateRate.dateUsername}')"><span class="glyphicon glyphicon-share"></span> Share</button>
          </div>
      </div>
    </div>
</div>