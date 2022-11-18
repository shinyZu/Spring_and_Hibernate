<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/17/22
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>luv2code Company Home Page</h2>
    <hr>
    <p>  Welcome to the luv2code Company Home Page!!!!!!!!!!!!!  </p>

    <%-- Add a logout button --%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout">
    </form:form>
</body>
</html>
