package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import br.cefet.sisbiblioteca.dao.BibliotecarioDao;
import br.cefet.sisbiblioteca.dao.LivroDao;
import br.cefet.sisbiblioteca.dao.UsuarioDao;
import br.cefet.sisbiblioteca.model.Bibliotecario;
import br.cefet.sisbiblioteca.model.Livro;
import br.cefet.sisbiblioteca.model.Usuario;

/**
 * Servlet implementation class ListarDadosEmprestimo
 */
public class ListarDadosEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarDadosEmprestimo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
            UsuarioDao usuarioDao = new UsuarioDao();
            LivroDao livroDao = new LivroDao();

            List<Bibliotecario> bibliotecarios = bibliotecarioDao.getAll();
            List<Usuario> usuarios = usuarioDao.getAll();
            List<Livro> livros = livroDao.getAll();

            request.setAttribute("bibliotecarios", bibliotecarios);
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("livros", livros);

            request.getRequestDispatcher("/frmcadastraremprestimo.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching data.");
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
