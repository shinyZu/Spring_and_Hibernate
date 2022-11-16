<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/12/22
  Time: 6:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
    The Customer is confirmed: ${customer.firstName} ${customer.lastName}
    <br><br>
    Free Pass Count: ${customer.freePasses}
    <br><br>
    Postal Code: ${customer.postalCode}
    <br><br>
    Course Code: ${customer.courseCode}
    <br><br>
</body>
</html>
