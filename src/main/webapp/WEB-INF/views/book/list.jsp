<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href='<c:url value="/book/add"/>'>dodaj</a>
<p><c:out value="${message}"/></p>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>title</th>
        <th>rationg</th>
        <th>publisher</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.rating}"/></td>
            <td>${book.publisher.firstName}
                    ${book.publisher.lastName}
            </td>
            <td>
                <a href='<c:url value="/book/edit/${book.id}"/>'>edytuj</a>
                <a href='<c:url value="/book/remove/confirm/${book.id}"/>'>usuń</a>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
