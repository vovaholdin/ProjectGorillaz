<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="user" items="${requestScope.users}">
    <p>Edit <a href="edit-user?id=${user.id}">${user.login}</a> </p>
</c:forEach>

</body>
</html>
