package br.cefet.sisbiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sisbiblioteca.model.Livro;
import br.cefet.sisbiblioteca.model.Genero;

public class LivroDao {
    private Connection con;

    public LivroDao() {
        con = ConnectionFactory.getConnection();
    }

    public void adicionar(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (titulo, autor, genero_id, dataDePublicacao, quantidadeEstoque, valor) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getGenero().getId());
            stmt.setDate(4, new java.sql.Date(livro.getDataDePublicacao().getTime()));
            stmt.setInt(5, livro.getQuantidadeEstoque());
            stmt.setFloat(6, livro.getValor());

            stmt.execute();
        }
    }

    public void atualizar(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, genero_id = ?, dataDePublicacao = ?, quantidadeEstoque = ?, valor = ? WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getGenero().getId());
            stmt.setDate(4, new java.sql.Date(livro.getDataDePublicacao().getTime()));
            stmt.setInt(5, livro.getQuantidadeEstoque());
            stmt.setFloat(6, livro.getValor());
            stmt.setInt(7, livro.getId());

            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM livro WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Livro getById(int id) throws SQLException {
        Livro livro = null;
        String sql = "SELECT l.*, g.id as genero_id, g.nome as genero_nome FROM livro l JOIN genero g ON l.genero_id = g.id WHERE l.id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    livro = new Livro();
                    livro.setId(rs.getInt("id"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAutor(rs.getString("autor"));
                    
                    Genero genero = new Genero();
                    genero.setId(rs.getInt("genero_id"));
                    genero.setNome(rs.getString("genero_nome"));
                    livro.setGenero(genero);
                    
                    livro.setDataDePublicacao(rs.getDate("dataDePublicacao"));
                    livro.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                    livro.setValor(rs.getFloat("valor"));
                }
            }
        }
        return livro;
    }

    public List<Livro> getAll() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT l.*, g.id as genero_id, g.nome as genero_nome FROM livro l JOIN genero g ON l.genero_id = g.id";

        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                
                Genero genero = new Genero();
                genero.setId(rs.getInt("genero_id"));
                genero.setNome(rs.getString("genero_nome"));
                livro.setGenero(genero);
                
                livro.setDataDePublicacao(rs.getDate("dataDePublicacao"));
                livro.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                livro.setValor(rs.getFloat("valor"));

                livros.add(livro);
            }
        }
        return livros;
    }
    public List<Livro> getByTitulo(String titulo) throws SQLException {
        List<Livro> livros = new ArrayList<>();

        String sql = "SELECT l.*, g.id as genero_id, g.nome as genero_nome FROM livro l JOIN genero g ON l.genero_id = g.id WHERE l.titulo LIKE ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + titulo + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livro livro = new Livro();
                    livro.setId(rs.getInt("id"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAutor(rs.getString("autor"));
                    
                    Genero genero = new Genero();
                    genero.setId(rs.getInt("genero_id"));
                    genero.setNome(rs.getString("genero_nome"));
                    livro.setGenero(genero);
                    
                    livro.setDataDePublicacao(rs.getDate("dataDePublicacao"));
                    livro.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                    livro.setValor(rs.getFloat("valor"));

                    livros.add(livro);
                }
            }
        }

        return livros;
    }
}
