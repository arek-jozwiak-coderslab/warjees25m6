<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <form:input path="title"/>
    <form:input path="description"/>
    <input type="range" name="rating" min="1" max="12" value="${book.rating}"/>
    <form:select path="publisher.id" items="${publishers}" itemLabel="lastName" itemValue="id"/>
    <br/>
    <form:checkboxes items="${allAuthors}" path="authors" itemLabel="lastName" itemValue="id"  />
    <input type="submit"/>
</form:form>


</body>
</html>
