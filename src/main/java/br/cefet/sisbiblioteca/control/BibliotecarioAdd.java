package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.cefet.sisbiblioteca.dao.BibliotecarioDao;
import br.cefet.sisbiblioteca.model.Bibliotecario;

/**
 * Servlet implementation class BibliotecarioAdd
 */
public class BibliotecarioAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecarioAdd() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String matricula = request.getParameter("matricula");
	
		Bibliotecario bibliotecario = new Bibliotecario();
		bibliotecario.setNome(nome);
		bibliotecario.setCpf(cpf);
		bibliotecario.setEmail(email);
		bibliotecario.setSenha(senha);
		bibliotecario.setMatricula(matricula);
		
		BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
		try {
			bibliotecarioDao.adicionar(bibliotecario);
		} catch (SQLException e) {
			e.printStackTrace();
		}

       response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
