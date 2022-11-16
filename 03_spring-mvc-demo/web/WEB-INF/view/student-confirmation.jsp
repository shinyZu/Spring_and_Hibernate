<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/11/22
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation Page</title>
</head>
<body>
    The Student is confirmed: ${student.firstName} ${student.lastName}
    <br><br>
    Country selected: ${student.country}
    <br><br>
    Favourite Language: ${student.favouriteLanguage}
    <br><br>
    Operating Systems:
    <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
</body>
</html>
