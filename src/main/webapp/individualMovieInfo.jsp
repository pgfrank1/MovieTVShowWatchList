<%@include file="taglib.jsp"%>
<html>
<c:import url="head.jsp"/>
<body>
    <c:import url="navbar.jsp" />
    <div class="container-fluid">
        <div class="row vh-100">
            <div class="col-sm-5 bg-dark-subtle p-4">
                <img class="img-fluid mx-auto d-block" src="https://image.tmdb.org/t/p/w500<c:out value='${movieInfo.posterPath}'/>" alt="${movieInfo.title}"/>
                <h3>${movieInfo.title}</h3>
                <p>${movieInfo.overview}</p>
            </div>
            <div class="col-sm-7">
                <div class="row">
                    <div class="col">
                        <h4>Budget</h4>
                        <p>
                            <fmt:setLocale value="EN_us" scope="page" />
                            <fmt:formatNumber value="${movieInfo.budget}" type="currency"/>
                        </p>
                    </div>
                    <div class="col">
                        <h4>Genre</h4>
                        <p>
                            <c:forEach var="genre" items="${movieInfo.genres}">
                                <c:out value="${genre.name}"/>
                            </c:forEach>
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <h4>Runtime</h4>
                        <p>${movieInfo.runtime} minutes</p>
                    </div>
                    <div class="col">
                        <h4>Release Date</h4>
                        <p>${movieInfo.releaseDate}</p>
                    </div>
                </div>
                <div class="row">
                    <c:choose>
                        <c:when test="${userName != null}">
                                    <c:out value="${userMovie}" />
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="./logIn">Login</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</body>
<c:import url="bootStrapScript.jsp" />
 </html>