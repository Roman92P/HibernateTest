<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 04.10.2020
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Custom fonts for this template-->
<%--    <link href="${pageContext.request.contextPath}/theme/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">--%>

    <!-- Custom styles for this template-->
    <title>Student Form</title>
    <style>
    body{
        border: #2c9faf;
        background-color: #1cc88a;
    }
    </style>
</head>

<body>
<form:form method="post" modelAttribute="student" id="form" >
    <div class="container-fluid">
    <label for="firstName">First Name</label>
    <form:input path="firstName" id="firstName"/>
    </div>
    <br>
    <label for="lastName">Last Name</label>
    <form:input path="lastName" id="lastName"/>
    <br>
    <label for="gender">Gender</label>
    <form:input path="gender" id="gender"/>
    <br>
    <label for="country">Country</label>
    <form:select path="country" items="${countries}" multiple="false"/>
    <br>
    <label for="note">Note</label>
    <form:input path="note" id="note"/>
    <br>
    <label for="mailingList">Mailing List</label>
    <form:checkbox path="mailingList" id="mailingList"/>
    <br>
    <label for="programmingList">Programming List</label>
    <form:select path="programmingList" items="${programmingList}" multiple="true"/>
    <br>
    <label for="hobbies">Hobbies</label>
    <form:checkboxes items="${hobbies}" path="hobbies" />
    <br>
    <input type="submit">
</form:form>
</body>
</html>
