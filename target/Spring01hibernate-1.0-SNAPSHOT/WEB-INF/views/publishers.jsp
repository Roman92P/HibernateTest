<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 06.10.2020
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Zadanie 6 Publishers</title>
</head>
<body>
<table border>
    <thead>
    <th>id</th>
    <th>Name</th>
    <th>Akcja 1</th>
    <th>Akcja 2</th>
    </thead>
    <tbody>
    <c:forEach items="${publishers}" var="publisher">
    <tr>
        <td>${publisher.id}</td>
        <td>${publisher.name}</td>
        <td><a href="/publisher/deletePublisherFromForm/${publisher.id}">Delete</a></td>
        <td><a href="/publisher/editPublisherFromForm/${publisher.id}">Edit</a></td>
    </tr>
    </c:forEach>
</table>
<h2>
    <a href="/publisher/addPublisherForm">Add publisher</a>
</h2>
</tbody>
</body>
</html>
