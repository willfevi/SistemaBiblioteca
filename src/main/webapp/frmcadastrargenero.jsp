<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cadastrar Genero</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/GeneroAdd" method="post">
        <div>
            <label for="nome">Nome do Gênero:</label>
            <input type="text" id="nome" name="nome" required>
        </div>
        <div>
            <input type="submit" value="Cadastrar">
        </div>
    </form>
</body>
</html>
