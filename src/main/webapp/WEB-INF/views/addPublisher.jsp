<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 06.10.2020
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Publisher Form</title>
</head>
<body>
<label> Dodaj Publishera</label>
<form:form method="post" modelAttribute="publisher" action="${pageContext.request.contextPath}/publisher/addPublisherFromForm">
    <p hidden><form:input path="id"/></p>
    <label for="name">Name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>
    <br>
    <input type="submit">
</form:form>
</body>
</html>
