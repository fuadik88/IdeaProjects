<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body style="margin-left: 3%; color: crimson">
<h1>Do your login stuff below ...</h1>
<div id="container">
    <form:form action="${pageContext.request.contextPath}/auth" method="POST">
        <c:if test="${param.error != null}">
            <i class="anime">Invalid username or password !</i>
        </c:if>
        <p>
            Username: <label>
            <input type="text" name="username" placeholder="Username"/>
        </label></p>
        <p>
            Password: <label>
            <input type="text" name="password" placeholder="Password"/>
        </label></p>
        <input type="submit" value="Sign in"/>
    </form:form>
</div>
</body>
</html>
