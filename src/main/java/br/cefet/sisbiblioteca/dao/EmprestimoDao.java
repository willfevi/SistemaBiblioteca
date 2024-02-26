package br.cefet.sisbiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sisbiblioteca.model.Bibliotecario;
import br.cefet.sisbiblioteca.model.Emprestimo;
import br.cefet.sisbiblioteca.model.Livro;
import br.cefet.sisbiblioteca.model.Usuario;

public class EmprestimoDao {
    private Connection con;

    public EmprestimoDao() {
        con = ConnectionFactory.getConnection();
    }

    public void adicionar(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo (bibliotecario_id, usuario_id, livro_id, dataDeRetorno) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, emprestimo.getBibliotecario().getId());
            stmt.setInt(2, emprestimo.getUser().getId());
            stmt.setInt(3, emprestimo.getLivro().getId());
            stmt.setDate(4, new java.sql.Date(emprestimo.getDataDeRetorno().getTime()));

            stmt.execute();
        }
    }
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM emprestimo WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
    public void atualizar(Emprestimo emprestimo) throws SQLException {
        String sql = "UPDATE emprestimo SET bibliotecario_id = ?, usuario_id = ?, livro_id = ?, dataDeRetorno = ? WHERE id = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, emprestimo.getBibliotecario().getId());
            stmt.setInt(2, emprestimo.getUser().getId());
            stmt.setInt(3, emprestimo.getLivro().getId());
            stmt.setDate(4, new java.sql.Date(emprestimo.getDataDeRetorno().getTime()));
            stmt.setInt(5, emprestimo.getId());

            stmt.executeUpdate();
        }
    }



    public Emprestimo getById(int id) throws SQLException {
        Emprestimo emprestimo = null;
        String sql = "SELECT e.*, b.id as bibliotecario_id, u.id as usuario_id, l.id as livro_id "
                   + "FROM emprestimo e "
                   + "JOIN bibliotecario b ON e.bibliotecario_id = b.id "
                   + "JOIN usuario u ON e.usuario_id = u.id "
                   + "JOIN livro l ON e.livro_id = l.id "
                   + "WHERE e.id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    emprestimo = new Emprestimo();
                    emprestimo.setId(rs.getInt("id"));

                    Bibliotecario bibliotecario = new Bibliotecario();
                    bibliotecario.setId(rs.getInt("bibliotecario_id"));
                    emprestimo.setBibliotecario(bibliotecario);

                    Usuario user = new Usuario();
                    user.setId(rs.getInt("usuario_id"));
                    emprestimo.setUser(user);

                    Livro livro = new Livro();
                    livro.setId(rs.getInt("livro_id"));
                    emprestimo.setLivro(livro);

                    emprestimo.setDataDeRetorno(rs.getDate("dataDeRetorno"));
                }
            }
        }
        return emprestimo;
    }

    public List<Emprestimo> getAll() throws SQLException {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT e.*, b.id as bibliotecario_id, b.nome as bibliotecario_nome, u.id as usuario_id, u.nome as usuario_nome, l.id as livro_id, l.titulo as livro_titulo "
                   + "FROM emprestimo e "
                   + "JOIN bibliotecario b ON e.bibliotecario_id = b.id "
                   + "JOIN usuario u ON e.usuario_id = u.id "
                   + "JOIN livro l ON e.livro_id = l.id";

        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("id"));

                Bibliotecario bibliotecario = new Bibliotecario();
                bibliotecario.setId(rs.getInt("bibliotecario_id"));
                bibliotecario.setNome(rs.getString("bibliotecario_nome"));
                emprestimo.setBibliotecario(bibliotecario);

                Usuario user = new Usuario();
                user.setId(rs.getInt("usuario_id"));
                user.setNome(rs.getString("usuario_nome"));
                emprestimo.setUser(user);

                Livro livro = new Livro();
                livro.setId(rs.getInt("livro_id"));
                livro.setTitulo(rs.getString("livro_titulo"));
                emprestimo.setLivro(livro);

                emprestimo.setDataDeRetorno(rs.getDate("dataDeRetorno"));

                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }
    public List<Emprestimo> getByNomeUsuario(String nomeUsuario) throws SQLException {
        List<Emprestimo> emprestimos = new ArrayList<>();
        
        String sql = "SELECT e.*, b.id as bibliotecario_id, b.nome as bibliotecario_nome, u.id as usuario_id, u.nome as usuario_nome, l.id as livro_id, l.titulo as livro_titulo "
                   + "FROM emprestimo e "
                   + "JOIN bibliotecario b ON e.bibliotecario_id = b.id "
                   + "JOIN usuario u ON e.usuario_id = u.id "
                   + "JOIN livro l ON e.livro_id = l.id "
                   + "WHERE u.nome = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Emprestimo emprestimo = new Emprestimo();
                    emprestimo.setId(rs.getInt("id"));

                    Bibliotecario bibliotecario = new Bibliotecario();
                    bibliotecario.setId(rs.getInt("bibliotecario_id"));
                    bibliotecario.setNome(rs.getString("bibliotecario_nome"));
                    emprestimo.setBibliotecario(bibliotecario);

                    Usuario user = new Usuario();
                    user.setId(rs.getInt("usuario_id"));
                    user.setNome(rs.getString("usuario_nome"));
                    emprestimo.setUser(user);

                    Livro livro = new Livro();
                    livro.setId(rs.getInt("livro_id"));
                    livro.setTitulo(rs.getString("livro_titulo"));
                    emprestimo.setLivro(livro);

                    emprestimo.setDataDeRetorno(rs.getDate("dataDeRetorno"));

                    emprestimos.add(emprestimo);
                }
            }
        }
        return emprestimos;
    }

}
