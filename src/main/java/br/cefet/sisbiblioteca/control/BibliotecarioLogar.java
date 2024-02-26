package br.cefet.sisbiblioteca.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import br.cefet.sisbiblioteca.dao.BibliotecarioDao;
import br.cefet.sisbiblioteca.model.Bibliotecario;

/**
 * Servlet implementation class BibliotecarioLogar
 */
public class BibliotecarioLogar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecarioLogar() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = null;
        String nextPage = null;

        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        Bibliotecario bibliotecario = null;
        BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();

        try {
            bibliotecario = bibliotecarioDao.logar(nome, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("bibliotecario", bibliotecario);

        if (bibliotecario == null) {
            msg = "Login inválido!";
            nextPage = "/login.jsp";
            request.setAttribute("msg", msg);
        } else {
            nextPage = "/index.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}
