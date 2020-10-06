<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 05.10.2020
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Zadanie 5 Lista autorów</title>
    <style>
        body {
            background-color: antiquewhite;
            }
        table{
            border-color: red;
        }

    </style>
</head>
<body>
<table border>
    <tr>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Akcja 1</th>
        <th>Akcja 2</th>
    </tr>
    <c:forEach var="author" items="${authorsList}">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="author/del/${author.id}">Delete</a></td>
            <td><a href="author/update/${author.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<h2>
    <a href="author/addNewAuthor">Add Author</a>
</h2>
</body>
</html>
