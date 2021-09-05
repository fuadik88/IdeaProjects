<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=16"/>
</head>
<body style="background-color: cornsilk">
<div id="wrapper">
    <div id="header">
        <h2>Customer Data Manager</h2>
    </div>

    <div id="container">
        <div id="content">
            <button class="add-button" onclick="location.href='addCustomer'">Add Customer</button>

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>

                <c:forEach var="tempCustomer" items="${customers}"> <!-- customers is name of Model -->
                    <c:url var="customerUpdate" value="/customer/updateForm"> <!-- var is variable to use-->
                        <c:param name="id" value="${tempCustomer.id}"/>       <!-- in this html context-->
                    </c:url>

                    <c:url var="customerDelete" value="/customer/deleteCustomer"> <!-- var is variable to use-->
                        <c:param name="id" value="${tempCustomer.id}"/>       <!-- in this html context-->
                    </c:url>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td><a href="${customerUpdate}">Update</a>
                        | <a href="${customerDelete}" onclick="return confirm('Are you sure to delete ${tempCustomer.firstName}?')">
                                Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <hr>
    </div>
    <button class="btn1" onclick="location.href='${pageContext.request.contextPath}/'">HOME</button>
</div>
</body>
</html>
