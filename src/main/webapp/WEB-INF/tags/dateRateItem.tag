<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="dateRate" required="true" type="com.idaterate.interfaces.dtos.DateRateDisplayItemDTO" %>

<div class="panel panel-default" >
    <div class="media" style="padding:20px;">
      <div class="media-left">
          <img src="http://www.free-emoticons.com/files/emoticons-smileys/6039.png" class="media-object"/>
      </div>
      <div class="media-body" style="position: relative;">
        <h4 class="media-heading">${dateRate.dateUsername} <span class="pull-right text-muted">Score: ${dateRate.score}</span></h4>
          <p class="text-muted"><i>${dateRate.datingSite}</i></p>
          <p>${dateRate.description}</p>
          <div class="text-primary" style="position: absolute; bottom: 5px;">
              <c:forEach var="hashtag" items="${dateRate.hashtags}">
                <span class="label label-info">${hashtag}</span>
              </c:forEach>
          </div>
      </div>
    </div>
</div>