package br.cefet.sisbiblioteca.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.cefet.sisbiblioteca.dao.BibliotecarioDao;
import br.cefet.sisbiblioteca.dao.EmprestimoDao;
import br.cefet.sisbiblioteca.dao.LivroDao;
import br.cefet.sisbiblioteca.dao.UsuarioDao;
import br.cefet.sisbiblioteca.model.Emprestimo;

/**
 * Servlet implementation class EmprestimoDadosParaAtualizar
 */
public class EmprestimoDadosParaAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmprestimoDadosParaAtualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        LivroDao livroDao = new LivroDao();

        try {
            Emprestimo emprestimo = emprestimoDao.getById(id);
            request.setAttribute("emprestimo", emprestimo);
            request.setAttribute("bibliotecarios", bibliotecarioDao.getAll());
            request.setAttribute("usuarios", usuarioDao.getAll());
            request.setAttribute("livros", livroDao.getAll());

            RequestDispatcher dispatcher = request.getRequestDispatcher("frmemprestimoatualizar.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro na base de dados.");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
