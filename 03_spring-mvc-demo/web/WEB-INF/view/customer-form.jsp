<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/12/22
  Time: 6:18 AM
  To change this template use File | Settings | File Templates.
--%>

<%--reference for spring form tag libraries--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>

    <small><i>Fill out the form. Asterisk(*) means required.</i></small>
    <br><br>

    <form:form action="processForm" modelAttribute="customer">

        First Name: <form:input path="firstName" />
        <br><br>

        Last Name(*): <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error"/>
        <br><br>

        Free Passes(*): <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error"/>
        <br><br>

        Postal Code: <form:input path="postalCode" />
        <form:errors path="postalCode" cssClass="error"/>
        <br><br>

        Course Code: <form:input path="courseCode" />
        <form:errors path="courseCode" cssClass="error"/>
        <br><br>

        <input type="submit" value="Submit">
    </form:form>

</body>
</html>
