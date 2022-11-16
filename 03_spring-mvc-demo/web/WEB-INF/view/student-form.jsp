<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/11/22
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First Name : <form:input path="firstName" />
        <br><br>

        Last Name : <form:input path="lastName" />
        <br><br>

        Country :
        <form:select path="country">
<%--            <form:option value="Brazil" label="Brazil" />--%>
<%--            <form:option value="France" label="France" />--%>
<%--            <form:option value="Germany" label="Germany" />--%>
<%--            <form:option value="India" label="India" />--%>
            <form:options items="${student.countryOptions}" />
        </form:select>
        <br><br>

        Favourite Language :
         <form:radiobutton path="favouriteLanguage" value="Java" /> Java
         <form:radiobutton path="favouriteLanguage" value="C#" /> C#
         <form:radiobutton path="favouriteLanguage" value="PHP" /> PHP
         <form:radiobutton path="favouriteLanguage" value="Ruby" /> Ruby
        <br><br>

        Operating Systems:
        <form:checkbox path="operatingSystems" value="Linux"/> Linux
        <form:checkbox path="operatingSystems" value="Mac OS"/> Mac OS
        <form:checkbox path="operatingSystems" value="Windows"/> MS Windows
        <br><br>

        <input type="submit" value="Submit">
    </form:form>

</body>
</html>
