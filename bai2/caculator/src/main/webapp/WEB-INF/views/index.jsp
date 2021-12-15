<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/14/2021
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Email Validation</title>
</head>
<body>
<h2>Computer</h2>
<form action="/calculator/cal">
  <input type="text" name ="a">
  <input type="text" name ="b">
  <button name="cal" value="plus" >+</button>
  <button name="cal" value="multi">x</button>
  <button name="cal" value="minus">-</button>
  <button name="cal" value="divide">/</button>
</form>
<p>Result: ${result}</p>
</body>
</html>