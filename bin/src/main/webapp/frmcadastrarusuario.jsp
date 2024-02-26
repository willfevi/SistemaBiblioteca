<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CadastroUsuario</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css">
</head>
<body>
    <div style="margin-bottom: 20px;">
        <a href="index.jsp">
            <button style="padding: 10px; font-size: 16px;">Home </button>
        </a>
    </div>
    <form action="UsuarioAdd" method="post">
   		 <h1>Cadastrar Usuario</h1>
        Nome: <input type="text" name="nome" ><br>
        CPF: <input type="text" name="cpf"><br>    
        Email: <input type="text" name="email"><br>
        Senha: <input type="password" name="senha"><br>       
        <input type="submit">
    </form>
</body>
</html>
