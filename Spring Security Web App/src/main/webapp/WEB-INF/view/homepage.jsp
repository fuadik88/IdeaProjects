<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>BEGIN</title>
    <style>
        .noselect {
            -webkit-touch-callout: none; /* iOS Safari */
            -webkit-user-select: none; /* Safari */
            -khtml-user-select: none; /* Konqueror HTML */
            -moz-user-select: none; /* Firefox */
            -ms-user-select: none; /* Internet Explorer/Edge */
            user-select: none; /* Non-prefixed version, currently
                                  supported by Chrome and Opera */
        }
        .btnLogout {width: 80px; height: 30px; font-weight: bolder}
    </style>
</head>
<body class="noselect">
<script>
    let num = 0;
    function counter() {
        num = num + 500;
        document.getElementById("count").innerHTML = num.toString();
    }
</script>
<h1>You came...</h1> <br>
<hr>
<p>
    User: <security:authentication property="principal.username"/> <br><br>  <!-- Displaying user and roles -->
    Role: <security:authentication property="principal.authorities"/> <br>
    Pass: <security:authentication property="principal.password"/> <!-- shows null -->
</p>
<hr>
<security:authorize access="hasRole('MANAGER')">
    <p> <a href="management">Leaders</a> </p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <p> <a href="system">Console</a> </p>
</security:authorize>

<br>
<h2 id="count" style="font-size: xxx-large; margin-left: 3%; display: inline; border: 10px dashed springgreen;" onmouseenter="counter()">0</h2>
<br><br><br>
<form:form action="logout" method="POST">
    <input type="submit" value="Logout" class="btnLogout"/>
</form:form>
</body>
</html>
