<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Livros</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/stylelivro.css">
</head>
<body>
    <h1>Livros</h1>
    <form action="LivroBuscar" method="get">
        Buscar: <input type="text" name="titulo" placeholder="Digite o título">
        <input type="submit" value="Buscar">
    </form>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Valor</th>
                <th>Data de Publicação</th>
                <th>Estoque</th>
                <th>Gênero</th>
            </tr>
        </thead>
        <tbody>
		<c:forEach var="livro" items="${livros}">
		    <tr>
		        <td>${livro.id}</td>
		        <td>${livro.titulo}</td>
		        <td>${livro.autor}</td>
		        <td>${livro.valor}</td>
		        <td>${livro.dataDePublicacao}</td>
		        <td>${livro.quantidadeEstoque}</td>
		        <td>${livro.genero.nome}</td>
		        <td>
		            <a href="LivroDelete?id=${livro.id}">
		                <img src="img/icon_delete.png" alt="Delete" style="width: 20px; height: 20px;">
		            </a>
		        </td>
		    </tr>
		</c:forEach>

        </tbody>
    </table>
</body>
</html>
