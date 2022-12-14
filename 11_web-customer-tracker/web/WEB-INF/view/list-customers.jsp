<%--
  Created by IntelliJ IDEA.
  User: shinyT480
  Date: 11/14/22
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </div>
</div>

<div id="container">
    <div id="content">

        <%--put new button : Add Customer--%>
        <input type="button" value="Add Customer" onclick="window.location.href='showForForAdd'; return false;"
               class="add-button"
        />

        <%--html table--%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <%-- loop over and print our customers --%>
            <c:forEach var="tempCustomer" items="${customers}">

                <!-- construct an "update" link with customer id-->
                <c:url var="updateLink" value="/customer/showForForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <!-- construct an "delete" link with customer id-->
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td>
                        <%-- display the update link--%>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                        onclick="if(!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
