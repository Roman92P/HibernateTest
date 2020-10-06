<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 05.10.2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Zadanie 5 Add Author</title>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/author/addNewAuthorFromForm" modelAttribute ="author">
    <p hidden><form:input path="id"/></p>
    <label for="firstName">Imię Autora</label>
    <form:input  path="firstName" id="firstName"/>
    <form:errors path="firstName"/>
    <br>
    <label for="lastName">Nazwisko Autora</label>
    <form:input path="lastName" id="lastName"/>
    <form:errors path="lastName"/>
    <br>
    <input type="submit"/>
</form:form>
</body>
</html>
