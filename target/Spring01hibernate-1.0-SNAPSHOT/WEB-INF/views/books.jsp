<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.publisher.name}</td>
            <td><a href="book/deleteById/${book.id}">Delete</a></td>
            <th><a href="book/editBook/${book.id}">Edit</a></th>
        </tr>
    </c:forEach>
</table>
<h2>
    <a href="book/addBook">Add Book</a>
</h2>
<form:form method="get" action="${pageContext.request.contextPath}/books/filter">
    <label for="rating">Rating:</label>
    <input type="text" id="rating" name="rating"><br><br>
    <input type="submit" value="Filter">
</form:form>
</body>
</html>