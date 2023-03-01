<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<c:import url="head.jsp" />
<body>
  <c:import url="navbar.jsp" />

  <div class="container">
      <c:import url="movieList.jsp" />
  </div>
  ${mapTest}
  ${mapTest.getClass()}
  <c:forEach items="${mapTest}" var="test">
      <c:out value="${test.original_title}" />
      <br><br>
  </c:forEach>

<c:import url="bootStrapScript.jsp" />
</body>
</html>
