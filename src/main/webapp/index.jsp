<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<c:import url="head.jsp"/>
<body>
    <main>
        <c:import url="navbar.jsp" />
        <h1>${apiKey}</h1>
        <div class="container">
            <div class="row">
                <div class="col-md p-2 mt-4">
                    <c:import url="movieList.jsp" />
                </div>
                <div class="col-md-1"></div>
                <div class="col-md p-2 mt-4">
                    <c:import url="tvShowList.jsp" />
                </div>
            </div>
        </div>
    </main>

<c:import url="bootStrapScript.jsp" />
</body>
</html>