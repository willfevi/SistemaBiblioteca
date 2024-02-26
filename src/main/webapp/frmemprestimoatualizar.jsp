<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Empréstimo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css">
</head>
<body>
    <form action="EmprestimoAtualizar" method="post">
        <input type="hidden" name="id" value="${emprestimo.id}">

        <label>Bibliotecário:</label>
        <select name="bibliotecario">
            <c:forEach var="bibliotecario" items="${bibliotecarios}">
                <option value="${bibliotecario.id}" ${bibliotecario.id == emprestimo.bibliotecario.id ? 'selected' : ''}>${bibliotecario.nome}</option>
            </c:forEach>
        </select>

        <label>Usuário:</label>
        <select name="usuario">
            <c:forEach var="usuario" items="${usuarios}">
                <option value="${usuario.id}" ${usuario.id == emprestimo.user.id ? 'selected' : ''}>${usuario.nome}</option>
            </c:forEach>
        </select>

        <label>Livro:</label>
        <select name="livro">
            <c:forEach var="livro" items="${livros}">
                <option value="${livro.id}" ${livro.id == emprestimo.livro.id ? 'selected' : ''}>${livro.titulo}</option>
            </c:forEach>
        </select>

        <label>Data de Retorno:</label>
        <input type="date" name="dataDeRetorno" value="${emprestimo.dataDeRetorno}">

        <input type="submit" value="Atualizar Empréstimo">
    </form>
</body>
</html>
