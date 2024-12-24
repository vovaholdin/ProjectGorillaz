<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="head.jsp" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Вход</title>
    <link rel="stylesheet" href="assets/css/login-page.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .login-form h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .login-form input[type="text"],
        .login-form input[type="email"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        .login-form button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-form button:hover {
            background-color: #0056b3;
        }

        .login-form .error {
            color: red;
            text-align: center;
            font-size: 14px;
        }

        .login-form .forgot-password {
            display: block;
            text-align: center;
            margin-top: 10px;
            font-size: 14px;
        }

        .login-form .forgot-password a {
            color: #007bff;
            text-decoration: none;
        }

        .login-form .forgot-password a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<c:if test="${not empty param.alertMessage}">
    <script>
        alert('<c:out value="${param.alertMessage}"/>');
    </script>
</c:if>

<div class="container">
    <div class="login-form">
        <h2>Вход в систему</h2>
        <form action="login-user" method="POST">
            <input type="text" name="login" placeholder="Login" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Пароль" required>
            <button type="submit">Войти</button>
        </form>
        <div class="forgot-password">
            <a href="forgot-password.jsp">Забыли пароль?</a>
        </div>
    </div>
</div>

</body>
</html>
