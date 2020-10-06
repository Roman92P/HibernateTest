<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 04.10.2020
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="select" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confrim Removing</title>
</head>
<body>
<LABEL>Czy chcesz usunąć książkę o id ${idForDelete}</LABEL>
<br>
<form method="post" action="confirmedRemoving">
    <input name="idForDelete" hidden value="${idForDelete}">
    <select name="delOrNot">
        <option value="1">Usunąć</option>
        <option value="0">Nie usuwać</option>
    </select>
    <input type="submit">
</form>

</body>
</html>
