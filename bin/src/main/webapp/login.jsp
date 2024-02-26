<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Biblioteca - Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/styleindex.css">
</head>
<body>
    <div style="text-align:center;">
        <h1>Login - Biblioteca</h1>
        <form action="${pageContext.request.contextPath}/BibliotecarioLogar" method="post">
            <div>
                <label for="nome">Nome:</label><br>
                <input type="text" id="nome" name="nome" required><br>
            </div>
            <div>
                <label for="senha">Senha:</label><br>
                <input type="password" id="senha" name="senha" required><br>
            </div>
            <div>
                <input type="submit" value="Logar">
            </div>
        </form>
        <% if(request.getAttribute("msg") != null) { %>
            <p style="color:red;">${msg}</p>
        <% } %>
    </div>
</body>
</html>
