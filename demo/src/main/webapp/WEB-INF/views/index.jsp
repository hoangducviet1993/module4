<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 12/13/2021
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/sum">
    <input type="text" name="a"><br>
    <input type="text" name="b"><br>
    <button>Nhấn</button>
  </form>
  <form action="/sum" method="post">
    <input type="text" name="a"><br>
    <input type="text" name="b"><br>
    <button>Nhấn</button>
  </form>
  </body>

</html>
