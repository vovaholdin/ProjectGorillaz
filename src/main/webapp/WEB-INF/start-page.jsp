<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Игра - Вопрос и Ответы</title>
    <link rel="stylesheet" href="assets/css/game-page.css">
    <link rel="stylesheet" href="assets/css/header.css">
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


<body>
<div class="container py-4 py-xl-5">
    <div class="row mb-5">
        <div class="col-md-8 col-xl-6 text-center mx-auto">
            <h2>Quest games</h2>
        </div>
    </div>
    <div class="row gy-4 row-cols-1 row-cols-md-2 row-cols-xl-3">
        <div class="col">
            <div class="p-4"><span class="badge rounded-pill bg-primary mb-2"></span>
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <!-- Если пользователь в сессии, показываем выбор -->
                        <h4>Ваш ноутбук стал плохо работать</h4>
                        <p>Сможете починить ваш ноутбук или прийдется купить новый?!</p>
                        <div class="d-flex">
                            <img class="rounded-circle flex-shrink-0 me-3 fit-cover" width="50" height="50" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png">
                            <div>
                                <!-- Кнопка для игры -->
                                <button type="button" onclick="startGame(1)">Играть</button>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <!-- Если пользователя нет в сессии, показываем ссылки для входа и регистрации -->
                        <h4>Вам нужно
                            <a href="/login-user" class="btn btn-primary">войти</a>
                            или
                            <a href="/register-user" class="btn btn-secondary">зарегистрировать</a>
                            аккаунт.
                        </h4>

                    </c:otherwise>
                </c:choose>

            </div>
    </div>
</div>

<!-- Встроенный JavaScript -->
<script>
    function startGame(gameId) {
        // Переход на страницу игры с параметром
        window.location.href = "game-page?id=" + gameId;
    }
</script>
</body>

