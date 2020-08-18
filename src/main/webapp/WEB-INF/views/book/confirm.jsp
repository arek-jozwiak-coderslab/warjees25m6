<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href='<c:url value="/book/remove/${id}"/> '>Potwierdź</a>
<a href='<c:url value="/book/list"/> '>Anuluj</a>
</body>
</html>
