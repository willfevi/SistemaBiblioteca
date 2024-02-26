<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Livro</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css">
</head>
<body>

<form action="/sisbiblioteca/LivroAdd" method="post">
    <h1>Registrar Livro</h1>
    Titulo: <input type="text" name="titulo" value="${livro.titulo}"> <br>
    Autor: <input type="text" name="autor" value="${livro.autor}"> <br>
	Genero:
	<select name="idGenero">
	    <c:forEach var="genero" items="${listGeneros}"> 
	        <option value="${genero.id}">${genero.nome}</option> 	
	    </c:forEach>
	</select>

    Data de Publicação:<input type="text" name="dataDePublicacao" value="${livro.dataDePublicacao}"> <br>
    
    Valor: <input type="text" name="valor" value="${livro.valor}"> <br>
	
	Quantidade em Estoque: <input type="text" name="quantidadeEstoque" value="${livro.quantidadeEstoque}"> <br>
	
    <input type="submit">
    
    <h1> ${msg}</h1>
</form>

</body>
</html>
