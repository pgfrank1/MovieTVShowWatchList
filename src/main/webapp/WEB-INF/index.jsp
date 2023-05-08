<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="page" value="Welcome!" var="pageTitle" />

<!DOCTYPE html>
<html lang="en">
<c:import url="../head.jsp"/>
<body>
    <main>
        <c:import url="../navbar.jsp" />
        <div class="container object-fit-fill">
            <div class="row">
                <div class="col-lg mt-4">
                    <h3>Trending Movies</h3>
                    <c:import url="../movieList.jsp" />
                </div>
                <div class="col-lg-1 m-xxl-5"></div>
                <div class="col-lg mt-4">
                    <h3>Trending TV Shows</h3>
                    <c:import url="../tvShowList.jsp" />
                </div>
            </div>
        </div>
    </main>
    <c:import url="../footer.jsp" />
<c:import url="../bootStrapScript.jsp" />
</body>
</html>