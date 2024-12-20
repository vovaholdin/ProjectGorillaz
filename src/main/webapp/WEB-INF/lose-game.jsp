<%--
  Created by IntelliJ IDEA.
  User: mrlol
  Date: 18.12.2024
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/result-game.css">
    <title>Проигрыш</title>
</head>
<body>
<!-- Атрибут result -->
<h1>${requestScope.result}</h1>

<!-- Кнопки -->
<div class="buttons">
    <a href="game-page?id=1" class="link-button">Начать заново</a>
    <a href="/" class="link-button">Вернуться на главную</a>
</div>
</body>
</html>