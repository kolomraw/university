<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вход</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">

    <style>
        .login-wrapper {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #f5f6fa;
        }

        .login-card {
            width: 100%;
            max-width: 400px;
            padding: 30px;
            border-radius: 12px;
            background: #fff;
            box-shadow: 0 5px 20px rgba(0,0,0,0.08);
        }

        .login-title {
            font-size: 24px;
            font-weight: 600;
            margin-bottom: 25px;
            text-align: center;
        }
    </style>
</head>

<body>

<div class="login-wrapper">

    <div class="login-card">

        <div class="login-title">Вход в систему</div>

        <%
            String error = request.getParameter("error");
            if ("1".equals(error)) {
        %>
            <div class="alert alert-danger text-center">
                Неверный логин или пароль
            </div>
        <%
            }
        %>

        <form method="POST" action="<%= request.getContextPath() %>/login">

            <div class="mb-3">
                <label class="form-label">Логин</label>
                <input type="text" name="login" class="form-control" required>
            </div>

            <div class="mb-4">
                <label class="form-label">Пароль</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <button class="btn btn-primary w-100">
                Войти
            </button>

        </form>

    </div>

</div>

</body>
</html>