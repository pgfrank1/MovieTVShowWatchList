<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${tvShowMap}" var="movie" step="2" begin="0" end="${tvShowMap.size()}" varStatus="i">
  <div class="row mt-4">
    <div class="card col">
      <img src="https://image.tmdb.org/t/p/w500<c:out value='${tvShowMap[i.index].poster_path}'/>" class="card-img-top" alt="<c:out value="${tvShowMap[i.index].name}" />">
      <div class="card-body">
        <h5 class="card-title">
          <c:out value="${tvShowMap[i.index].name}" />
        </h5>
        <c:choose>
          <c:when test="${empty tvShowMap[i.index].overview}">
            <p class="card-text">No description</p>
          </c:when>
          <c:otherwise>
            <p class="card-text"><c:out value="${tvShowMap[i.index].overview}" /></p>
          </c:otherwise>
        </c:choose>
        <a href="./TVShowInfo?tv_id=${tvShowMap[i.index].id}" class="btn btn-primary">Get Info</a>
      </div>
    </div>
    <div class="card col">
      <img src="https://image.tmdb.org/t/p/w500<c:out value='${tvShowMap[i.index + 1].poster_path}'/>" class="card-img-top" alt="<c:out value="${tvShowMap[i.index + 1].name}" />">
      <div class="card-body">
        <h5 class="card-title">
          <c:out value="${tvShowMap[i.index + 1].name}" />
        </h5>
        <c:choose>
          <c:when test="${empty tvShowMap[i.index + 1].overview}">
            <p class="card-text">No description</p>
          </c:when>
          <c:otherwise>
            <p class="card-text"><c:out value="${tvShowMap[i.index + 1].overview}" /></p>
          </c:otherwise>
        </c:choose>
        <a href="./TVShowInfo?tv_id=${tvShowMap[i.index].id}" class="btn btn-primary">Get Info</a>
      </div>
    </div>
  </div>
</c:forEach>