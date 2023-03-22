<%@include file="taglib.jsp"%>

<html>
<c:import url="head.jsp" />
<body>
  <c:import url="navbar.jsp" />
  <div class="container-fluid">
    <div class="row vh-100">
      <div class="col-sm-5 bg-dark-subtle p-4">
        <img class="img-fluid mx-auto d-block" src="<c:out value="${posterImageUrl}"/><c:out value='${showInfo.posterPath}'/>" alt="${showInfo.name}"/>
        <h3>${showInfo.name}</h3>
        <p>${showInfo.overview}</p>
      </div>
      <div class="col-sm-7">
        <div class="row">
          <div class="col">
            <h4>Budget</h4>
          </div>
          <div class="col">
            <h4>Genre</h4>
            <p>
              <c:forEach var="genre" items="${showInfo.genres}">
                <c:out value="${genre.name}"/>
              </c:forEach>
            </p>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <h4>Runtime</h4>
          </div>
          <div class="col">
            <h4>Release Date</h4>
          </div>
        </div>
      </div>
    </div>
  </div>
  <c:import url="bootStrapScript.jsp" />
</body>

</html>