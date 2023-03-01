<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<c:import url="head.jsp"/>
<body>
    <main>
        <c:import url="navbar.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md mt-4">
                    <h3>Trending Movies</h3>
                    <c:import url="movieList.jsp" />
                </div>
                <div class="col-md-1"></div>
                <div class="col-md mt-4">
                    <h3>Trending TV Shows</h3>
                    <c:import url="tvShowList.jsp" />
                </div>
            </div>
        </div>
    </main>

<c:import url="bootStrapScript.jsp" />
</body>
</html>