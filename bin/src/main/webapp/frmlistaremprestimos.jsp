<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Empréstimos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/styleemprestimo.css">
</head>
<body>
    <h1>Empréstimos</h1>
    <form action="EmprestimoBuscar" method="get">
        Buscar: <input type="text" name="nomeUsuario" placeholder="Digite o nome do usuário">
        <input type="submit" value="Buscar">
    </form>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Bibliotecario</th>
                <th>Nome do Usuário</th>
                <th>Título do Livro</th>
                <th>Data de Retorno</th>
                <th>Editar</th> <!-- Added Column for Editing -->
                <th>Deletar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="emprestimo" items="${emprestimos}">
                <tr>
                    <td>${emprestimo.id}</td>
                    <td>${emprestimo.bibliotecario.nome}</td>
                    <td>${emprestimo.user.nome}</td>
                    <td>${emprestimo.livro.titulo}</td>
                    <td>${emprestimo.dataDeRetorno}</td>
                    <td>
                        <a href="EmprestimoDadosParaAtualizar?id=${emprestimo.id}">
                            <img src="img/icon_edit.png" alt="Edit" style="width: 20px; height: 20px;">
                        </a>
                    </td>
                    <td>
                        <a href="EmprestimoDelete?id=${emprestimo.id}">
                            <img src="img/icon_delete.png" alt="Delete" style="width: 20px; height: 20px;">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
