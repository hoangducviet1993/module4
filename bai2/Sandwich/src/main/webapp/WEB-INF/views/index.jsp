<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/14/2021
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Email Validation</title>
</head>
<body>

<h2>Sandwich Condiments</h2>
<form action="/sandwich/save">
  <input type="checkbox" value="Lettuce" name="condiment"> Lettuce
  <input type="checkbox" value="Tomato" name="condiment"> Tomato
  <input type="checkbox" value="Mustard" name="condiment"> Mustard
  <input type="checkbox" value="Sprouts" name="condiment"> Sprouts
  <br><button>save</button>
</form>
</body>
</html>