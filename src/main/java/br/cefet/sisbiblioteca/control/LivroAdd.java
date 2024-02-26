package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.cefet.sisbiblioteca.dao.LivroDao;
import br.cefet.sisbiblioteca.dao.GeneroDao;
import br.cefet.sisbiblioteca.model.Livro;
import br.cefet.sisbiblioteca.model.Genero;

public class LivroAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LivroAdd() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");

        String generoIdStr = request.getParameter("idGenero");
        if(generoIdStr == null || generoIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Genero ID is missing.");
            return;
        }
        int generoId = Integer.parseInt(generoIdStr);

        GeneroDao generoDao = new GeneroDao();
        Genero genero = null;
        try {
            genero = generoDao.getById(generoId);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching genero.");
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDePublicacao = null;
        try {
            dataDePublicacao = format.parse(request.getParameter("dataDePublicacao"));
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format.");
            return;
        }
       
        String valorStr = request.getParameter("valor");
        float valor = 0.0f;
        if (valorStr != null && !valorStr.isEmpty()) {
            valor = Float.parseFloat(valorStr);
        }

        String quantidadeEstoqueStr = request.getParameter("quantidadeEstoque");
        int quantidadeEstoque = 0;
        if (quantidadeEstoqueStr != null && !quantidadeEstoqueStr.isEmpty()) {
            quantidadeEstoque = Integer.parseInt(quantidadeEstoqueStr);
        }
       
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setDataDePublicacao(dataDePublicacao);
        livro.setQuantidadeEstoque(quantidadeEstoque);
        livro.setValor(valor); 

        LivroDao livroDao = new LivroDao();
        try {
            livroDao.adicionar(livro);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding livro.");
            return;
        }

        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
