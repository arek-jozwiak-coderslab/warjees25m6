<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="book">
<%--    <form:errors path="*" />--%>
    <br/>
    <br/>
    <form:hidden path="id"/>
    <label>title</label>
    <form:input path="title"/>
    <form:errors path="title" />
    <br/>
    <label>pages</label>
    <form:input path="pages"/>
    <form:errors path="pages" />
    <br/>
    <label>description</label>
    <form:input path="description"/>
    <form:errors path="description" />
    <br/>
    <label>rating</label>
    <form:input path="rating"/>
    <form:errors path="rating" />
    <br/>
    <label>publisher</label>
    <form:select path="publisher.id" items="${publishers}" itemLabel="lastName" itemValue="id"/>
    <form:errors path="publisher" />
    <br/>
    <form:checkboxes items="${allAuthors}" path="authors" itemLabel="lastName" itemValue="id"  />
    <form:errors path="authors" />
    <input type="submit"/>
</form:form>


</body>
</html>
