<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 12/13/2021
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/currency" method="post">
    <input type="text" name="usd" placeholder="Nhập số tiền VND">
    <input type="text" name="curr" placeholder="Nhập tỷ lệ chuyển" value=23000>
    <button>Chuyển</button>
</form>
<h2>Giá trị : ${currency}</h2>
</body>
</html>
