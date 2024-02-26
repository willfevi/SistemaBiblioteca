package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefet.sisbiblioteca.dao.EmprestimoDao;
import br.cefet.sisbiblioteca.model.Emprestimo;

/**
 * Servlet implementation class EmprestimoBuscar
 */
public class EmprestimoBuscar extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmprestimoBuscar() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        String nomeUsuario = request.getParameter("nomeUsuario");
        
        try {
            List<Emprestimo> emprestimos = emprestimoDao.getByNomeUsuario(nomeUsuario);
            request.setAttribute("emprestimos", emprestimos);
            request.getRequestDispatcher("/frmlistaremprestimos.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar empréstimos.");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
