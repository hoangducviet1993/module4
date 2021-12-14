<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 12/9/2021
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create a Product</h1>
<form method="post">
    <table  cellpadding="5" style="text-align: left">
<%--        <tr>--%>
<%--            <th>Id:</th>--%>
<%--            <td><input type="number" name="id"></td>--%>
        </tr>
        <tr>
            <th>Name:</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Price:</th>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <th>Quantity:</th>
            <td><input type="number" name="quantity"></td>
        </tr>
        <tr>
            <th>Color::</th>
            <td><input type="text" name="color"></td>
        </tr>
        <tr>
            <th>CategoryID:</th>
           <td>
               <select name="categoryId">
                   <option value="">-</option>
                   <c:forEach var="category" items="${categories}">
                       <option value="${category.id}">${category.id}. ${category.name}</option>
                   </c:forEach>
               </select>
           </td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="Create"></td>
        </tr>
    </table>
</form>
<a href="/products"><h3>Back to product list</h3></a>
</body>
</html>