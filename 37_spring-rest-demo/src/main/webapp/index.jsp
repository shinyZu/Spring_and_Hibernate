<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/19/22
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    Spring Rest Demo
    <hr>

    <a href="${pageContext.request.contextPath}/test/hello">Hello</a>
    <br>
    <a href="test/hello">Hello</a>
    <br>
    <a href="api/students">Get All Students</a>
</body>
</html>
