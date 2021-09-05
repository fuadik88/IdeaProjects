<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Customer Entry</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=4">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css?version=5">
    <style>.err{color: red; font-style: italic;}</style>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Customer Data Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="newcustomer" method="post">
            <form:hidden path="id"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="firstName"/></td>
                        <td><form:errors path="firstName" cssClass="err"/></td>
                    </tr>

                    <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName"/></td>
                        <td><form:errors path="lastName" cssClass="err"/></td>
                    </tr>

                    <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email" cssClass="err"/></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><form:button class="save">Save</form:button> </td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        
        <p style="font-weight: bolder"><a href="${pageContext.request.contextPath}/customer/list">Go back to list</a></p>
    </div>
</body>
</html>
