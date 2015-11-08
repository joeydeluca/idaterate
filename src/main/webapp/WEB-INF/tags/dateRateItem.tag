<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="dateRate" required="true" type="com.idaterate.interfaces.dtos.DateRateDisplayItemDTO" %>

<div id="dateRateItem" class="panel panel-default" >
    <div class="media" style="padding:20px;">
      <div class="media-left">
          <a href="/viewdaterate?id=${dateRate.id}">
              <c:choose>
                  <c:when test="${dateRate.score <= 5}">
                        <img src="http://www.free-emoticons.com/files/emoticons-smileys/6039.png" class="media-object"/>
                  </c:when>
                  <c:when test="${dateRate.score > 5}">
                      <img src="http://www.free-emoticons.com/files/emoticons-smileys/6037.png" class="media-object"/>
                  </c:when>
              </c:choose>
          </a>
      </div>
      <div class="media-body" style="position: relative;">
        <h4 class="media-heading">${dateRate.dateUsername} <span class="pull-right text-muted">Score: ${dateRate.score}</span></h4>
          <p class="text-muted"><i>${dateRate.datingSite} | ${dateRate.city}</i></p>
          <p>${dateRate.description}</p>
          <c:forEach var="hashtag" items="${dateRate.hashtags}">
            <span class="label label-info">${hashtag}</span>
          </c:forEach>
          <a href="javascript:share('${dateRate.id}','${dateRate.dateUsername}','${dateRate.description}')">share</a>
      </div>
    </div>
</div>