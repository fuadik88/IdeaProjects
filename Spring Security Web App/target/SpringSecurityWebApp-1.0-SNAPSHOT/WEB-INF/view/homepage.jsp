<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
</head>
<body class="noselect">
<script>
    let num = 0;
    document.getElementById("count").innerHTML = num.toString();
    function counter() {
        num = num + 500;
        document.getElementById("count").innerHTML = num.toString();
    }
</script>
<h1>You came...</h1>
<br>
<h2 id="count" style="font-size: xxx-large; margin-left: 3%; display: inline; border: 10px dashed springgreen;" onmouseenter="counter()">0</h2>
</body>
</html>
