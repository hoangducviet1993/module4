<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/13/2021
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/trans" method="post">
    <input type="text" name="word">
    <button>Translate</button>
</form>
<h3>Result : ${result}</h3>
</body>
</html>
