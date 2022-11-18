<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/17/22
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>luv2code Company Home Page</h2>
    <hr>

    <p>  Welcome to the luv2code Company Home Page!!!!!!!!!!!!!  </p>
    <hr>

    <%-- display username & role  --%>
    <p>
        User: <security:authentication property="principal.username"/>
        <br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>
    <hr>

    <%-- Add a link to point to /leaders... this is for the managers  --%>
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        (Only for Manager peeps)
    </p>

    <%-- Add a link to point to /systems... this is for the admin  --%>
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        (Only for Admin peeps)
    </p>

    <hr>

    <%-- Add a logout button --%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout">
    </form:form>
</body>
</html>
