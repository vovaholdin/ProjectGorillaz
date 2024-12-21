<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Игра - Вопрос и Ответы</title>
    <link rel="stylesheet" href="assets/css/game-page.css">
    <style>
        /* Стили для навигационного меню */
        header {
            background-color: #333;
            padding: 10px 0;
            position: fixed; /* Закрепляем сверху */
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1000; /* Чтобы меню было поверх остального контента */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .navigation ul {
            list-style: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .navigation li {
            display: inline;
            margin: 0 15px;
        }

        .navigation a {
            text-decoration: none;
            color: white;
            font-size: 16px;
        }

        .navigation a:hover {
            color: #00aced;
        }

        /* Добавим отступ для основного контента, чтобы меню не перекрывало текст */
        body {
            margin: 0;
            padding-top: 60px; /* Высота header + небольшой отступ */
        }
    </style>
</head>
<body>

<!-- Header с навигационным меню -->
<header>
    <nav class="navigation">
        <ul>
            <li><a href="/">Главное меню</a></li>
            <li><a href="list-user">Пользователи</a></li>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <!-- Если пользователь есть в сессии, показываем выход -->
                    <li><a href="logout-user">Выйти из аккаунта</a></li>
                </c:when>
                <c:otherwise>
                    <!-- Если пользователя нет в сессии, показываем регистрацию -->
                    <li><a href="register-user">Регистрация</a></li>
                    <li><a href="login-user">Вход</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>