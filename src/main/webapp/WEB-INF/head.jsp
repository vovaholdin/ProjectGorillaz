
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Default Title</title>
</head>
<body>
<!-- Header -->
<header>
    <nav class="navigation">
        <ul>
            <li><a href="home">Главное меню</a></li>
            <li><a href="login.jsp">Вход</a></li>
            <li><a href="register.jsp">Регистрация</a></li>
            <li><a href="users">Пользователи</a></li>
        </ul>
    </nav>
</header>

<!-- Стили для header -->
<style>
    header {
        background-color: #333;
        padding: 10px 0;
        text-align: center;
        margin-bottom: 20px;
    }

    .navigation ul {
        list-style: none;
        margin: 0;
        padding: 0;
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
</style>