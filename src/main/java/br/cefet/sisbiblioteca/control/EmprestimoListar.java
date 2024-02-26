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

public class EmprestimoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmprestimoListar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        try {
            List<Emprestimo> emprestimos = emprestimoDao.getAll();
            request.setAttribute("emprestimos", emprestimos);
            request.getRequestDispatcher("/frmlistaremprestimos.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar empréstimos.");
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
