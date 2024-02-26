package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.cefet.sisbiblioteca.dao.LivroDao;

public class LivroDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LivroDelete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if(idStr == null || idStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book ID is missing.");
            return;
        }
        int id = Integer.parseInt(idStr);
       
        LivroDao livroDao = new LivroDao();
        try {
            livroDao.deletar(id);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting book.");
            return;
        }
        response.sendRedirect("LivroListar?next=frmlistarlivro.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
