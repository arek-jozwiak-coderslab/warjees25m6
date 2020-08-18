<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post"
           modelAttribute="student">
    <form:input path="firstName"  />
    <form:input path="lastName" />
    <input type="submit" value="Save">
</form:form>
</body>
</html>
