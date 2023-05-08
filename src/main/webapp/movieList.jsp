<%@include file="taglib.jsp"%>

<c:forEach items="${movieMap.results}" var="movie" step="2" begin="0" end="${movieMap.results.size()}" varStatus="i">
  <div class="row mt-4">
      <div class="card col">
        <img src="<c:out value="${posterImageUrl}"/><c:out value="${movieMap.results[i.index].posterPath}"/>" class="card-img-top" alt="<c:out value="${movieMap.results[i.index].title}" />">
        <div class="card-body">
          <h5 class="card-title">
              <c:out value="${movieMap.results[i.index].title}" />
          </h5>
          <p class="card-text"><c:out value="${movieMap.results[i.index].overview}" /></p>
          <a href="./MovieInfo?movie_id=${movieMap.results[i.index].id}" class="btn btn-primary">Movie Info</a>
        </div>
      </div>
      <div class="card col">
          <img src="<c:out value="${posterImageUrl}"/><c:out value="${movieMap.results[i.index + 1].posterPath}"/>" class="card-img-top" alt="<c:out value="${movieMap.results[i.index + 1].title}" />">
          <div class="card-body">
              <h5 class="card-title">
                  <c:out value="${movieMap.results[i.index + 1].title}" />
              </h5>
              <p class="card-text"><c:out value="${movieMap.results[i.index + 1].overview}" /></p>
              <a href="./MovieInfo?movie_id=${movieMap.results[i.index + 1].id}" class="btn btn-primary">Movie Info</a>
          </div>
      </div>
  </div>
</c:forEach>