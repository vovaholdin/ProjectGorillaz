<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Игра - Вопрос и Ответы</title>
    <link rel="stylesheet" href="assets/css/game-page.css">
</head>
<body>
<!-- Вопрос по центру -->
<h1>${requestScope.question}</h1>

<!-- Ответы справа и слева -->
<div class="answers">
    <c:forEach var="option" items="${requestScope.options}">
        <form action="game-page" method="post">
            <!-- Скрытые поля для передачи атрибутов кнопки -->
            <input type="hidden" name="id" value="${option.nextStep}">
            <input type="hidden" name="restart" value="${option.restart}">
            <input type="hidden" name="end" value="${option.end}">
            <input type="hidden" name="result" value="${option.result}">
            <!-- Кнопка для отправки формы -->
            <button type="submit" class="answer">
                    ${option.text}
            </button>
        </form>
    </c:forEach>
</div>
</body>
</html>
