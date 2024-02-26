package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefet.sisbiblioteca.dao.GeneroDao;
import br.cefet.sisbiblioteca.model.Genero;

/**
 * Servlet implementation class ListarGenero
 */
public class ListarGenero extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GeneroDao generoDao = new GeneroDao();
        try {
            List<Genero> listGeneros = generoDao.getAll();
            request.setAttribute("listGeneros", listGeneros);
            request.getRequestDispatcher("frmcadastrarlivro.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar gêneros.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
