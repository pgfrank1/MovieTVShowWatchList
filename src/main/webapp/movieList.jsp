<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${movieMap}" var="movie" step="2" begin="0" end="${movieMap.size()}" varStatus="i">
  <div class="row mt-4">
      <div class="card col">
        <img src="https://image.tmdb.org/t/p/w500<c:out value='${movieMap[i.index].poster_path}'/>" class="card-img-top" alt="<c:out value="${movieMap[i.index].title}" />">
        <div class="card-body">
          <h5 class="card-title">
              <c:out value="${movieMap[i.index].title}" />
          </h5>
          <p class="card-text"><c:out value="${movieMap[i.index].overview}" /></p>
          <a href="./MovieInfo?movie_id=${movieMap[i.index].id}" class="btn btn-primary">Movie Info</a>
        </div>
      </div>
      <div class="card col">
          <img src="https://image.tmdb.org/t/p/w500<c:out value='${movieMap[i.index + 1].poster_path}'/>" class="card-img-top" alt="<c:out value="${movieMap[i.index + 1].title}" />">
          <div class="card-body">
              <h5 class="card-title">
                  <c:out value="${movieMap[i.index + 1].title}" />
              </h5>
              <p class="card-text"><c:out value="${movieMap[i.index + 1].overview}" /></p>
              <a href="./MovieInfo?movie_id=${movieMap[i.index + 1].id}" class="btn btn-primary">Movie Info</a>
          </div>
      </div>
  </div>
</c:forEach>