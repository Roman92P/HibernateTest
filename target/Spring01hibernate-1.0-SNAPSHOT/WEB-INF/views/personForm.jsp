<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
Person
<form:form method="post" modelAttribute="person" >
    <p hidden><form:input path="id"/></p>
    <label for="login">Login</label>
    <form:input path="login" id="login"/>
    <br>
    <label for="password">Password</label>
    <form:password path="password" id="password"/>
    <br>
    <label for="email">Email</label>
    <form:input path="email" id="email"/>
    <br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>