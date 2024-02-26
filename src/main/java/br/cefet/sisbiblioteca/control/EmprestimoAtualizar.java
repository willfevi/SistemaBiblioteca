package br.cefet.sisbiblioteca.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import br.cefet.sisbiblioteca.dao.BibliotecarioDao;
import br.cefet.sisbiblioteca.dao.EmprestimoDao;
import br.cefet.sisbiblioteca.dao.UsuarioDao;
import br.cefet.sisbiblioteca.dao.LivroDao;
import br.cefet.sisbiblioteca.model.Bibliotecario;
import br.cefet.sisbiblioteca.model.Usuario;
import br.cefet.sisbiblioteca.model.Livro;
import br.cefet.sisbiblioteca.model.Emprestimo;

public class EmprestimoAtualizar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmprestimoAtualizar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int bibliotecarioId = Integer.parseInt(request.getParameter("bibliotecario"));
        int usuarioId = Integer.parseInt(request.getParameter("usuario"));
        int livroId = Integer.parseInt(request.getParameter("livro"));
        Date dataDeRetorno = Date.valueOf(request.getParameter("dataDeRetorno"));

        BibliotecarioDao bibliotecarioDao = new BibliotecarioDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        LivroDao livroDao = new LivroDao();

        Bibliotecario bibliotecario;
        Usuario user;
        Livro livro;

        try {
            bibliotecario = bibliotecarioDao.getById(bibliotecarioId);
            user = usuarioDao.getById(usuarioId);
            livro = livroDao.getById(livroId);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(id);
        emprestimo.setBibliotecario(bibliotecario);
        emprestimo.setUser(user);
        emprestimo.setLivro(livro);
        emprestimo.setDataDeRetorno(dataDeRetorno);

        EmprestimoDao emprestimoDao = new EmprestimoDao();
        try {
            emprestimoDao.atualizar(emprestimo);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        response.sendRedirect("EmprestimoListar?next=listaremprestimos.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
