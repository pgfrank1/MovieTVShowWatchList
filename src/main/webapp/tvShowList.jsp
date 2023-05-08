<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${tvShowMap.results}" var="movie" step="2" begin="0" end="${tvShowMap.results.size()}" varStatus="i">
  <div class="row mt-4">
    <div class="card col">
      <img src="<c:out value="${posterImageUrl}"/><c:out value="${tvShowMap.results[i.index].posterPath}"/>" class="card-img-top" alt="<c:out value="${tvShowMap.results[i.index].name}" />">
      <div class="card-body">
        <h5 class="card-title">
          <c:out value="${tvShowMap.results[i.index].name}" />
        </h5>
        <c:choose>
          <c:when test="${empty tvShowMap.results[i.index].overview}">
            <p class="card-text">No description</p>
          </c:when>
          <c:otherwise>
            <p class="card-text"><c:out value="${tvShowMap.results[i.index].overview}" /></p>
          </c:otherwise>
        </c:choose>
        <a href="./TVShowInfo?tv_id=${tvShowMap.results[i.index].id}" class="btn btn-primary">Get Info</a>
      </div>
    </div>
    <div class="card col">
      <img src="<c:out value="${posterImageUrl}"/><c:out value="${tvShowMap.results[i.index + 1].posterPath}"/>" class="card-img-top" alt="<c:out value="${tvShowMap.results[i.index + 1].name}" />">
      <div class="card-body">
        <h5 class="card-title">
          <c:out value="${tvShowMap.results[i.index + 1].name}" />
        </h5>
        <c:choose>
          <c:when test="${empty tvShowMap.results[i.index + 1].overview}">
            <p class="card-text">No description</p>
          </c:when>
          <c:otherwise>
            <p class="card-text"><c:out value="${tvShowMap.results[i.index + 1].overview}" /></p>
          </c:otherwise>
        </c:choose>
        <a href="./TVShowInfo?tv_id=${tvShowMap.results[i.index + 1].id}" class="btn btn-primary">Get Info</a>
      </div>
    </div>
  </div>
</c:forEach>