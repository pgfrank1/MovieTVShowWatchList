<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<c:import url="head.jsp" />
<body>
  <c:import url="navbar.jsp" />
  <div class="container-fluid">
    <div class="row vh-100">
      <div class="col-sm-5 bg-dark-subtle p-4">
        <img class="img-fluid mx-auto d-block" src="https://image.tmdb.org/t/p/w500<c:out value='${tvShowInfo.poster_path}'/>" alt="${tvShowInfo.title}"/>
        <h3>${tvShowInfo.title}</h3>
        <p>${tvShowInfo.overview}</p>
      </div>
      <div class="col-sm-7">
        <div class="row">
          <div class="col">
            <h4>Budget</h4>
            <p>
              <fmt:setLocale value="EN_us" scope="page" />
              <fmt:formatNumber value="${tvShowInfo.budget}" type="currency"/>
            </p>
          </div>
          <div class="col">
            <h4>Genre</h4>
            <p>
              <c:forEach var="genre" items="${tvShowInfo.genres}">
                <c:out value="${genre.name}"/>
              </c:forEach>
            </p>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <h4>Runtime</h4>
            <p>${tvShowInfo.runtime} minutes</p>
          </div>
          <div class="col">
            <h4>Release Date</h4>
            <p>${tvShowInfo.release_date}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <c:import url="bootStrapScript.jsp" />
</body>

</html>