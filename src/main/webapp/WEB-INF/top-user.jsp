<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Топ игроков</title>
    <link rel="stylesheet" href="assets/css/top-players.css">
</head>
<body>
<div class="container">
    <h1 class="header">Топ игроков</h1>
    <div class="players">
        <!-- Используем foreach для отображения игроков -->
        <c:forEach var="user" items="${requestScope.users}">
            <div class="player-card">
                <p class="player-login">${user.login}</p>
                <div class="stats">
                    <p>Win: ${user.statisticUsers.win}</p>
                    <p>Lose: ${user.statisticUsers.lose}</p>
                    <p>Score: ${user.statisticUsers.score}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
