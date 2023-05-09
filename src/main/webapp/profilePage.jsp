<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<c:import url="./head.jsp"/>
<body>
<main>
    <c:import url="./navbar.jsp" />
    <div class="container object-fit-fill">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Username</th>
                    <th scope="col">Profile Photo Location</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                </tr>
            <tbody>
            <c:forEach var="user" items="${userMovies}" >
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.user}" /></td>
                    <td><c:out value="${user.watched}" /></td>
                    <td><c:out value="${user.planned}" /></td>
                    <td><c:out value="${user.watching}" /></td>
                </tr>
            </c:forEach>
            <c:forEach var="user" items="${userTVShows}" >
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.user}" /></td>
                    <td><c:out value="${user.watched}" /></td>
                    <td><c:out value="${user.planned}" /></td>
                    <td><c:out value="${user.watching}" /></td>
                </tr>
            </c:forEach>
            </tbody>
            </thead>
        </table>
    </div>
</main>

<c:import url="./bootStrapScript.jsp" />
</body>
</html>