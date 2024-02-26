package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import br.cefet.sisbiblioteca.dao.EmprestimoDao;

public class EmprestimoDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmprestimoDelete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Loan ID is missing.");
            return;
        }
        int id = Integer.parseInt(idStr);

        EmprestimoDao emprestimoDao = new EmprestimoDao();
        try {
            emprestimoDao.excluir(id);
            emprestimoDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting loan. Details: " + e.getMessage());
            return;
        }

        response.sendRedirect("EmprestimoListar?next=listaremprestimos.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
