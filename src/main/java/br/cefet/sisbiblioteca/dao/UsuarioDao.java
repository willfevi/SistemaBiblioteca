package br.cefet.sisbiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sisbiblioteca.model.Usuario;

public class UsuarioDao {
    private Connection con;    
    
    public UsuarioDao() {
        con = ConnectionFactory.getConnection();
    }

    public void adicionar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, cpf, email, senha) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getCpf());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getSenha());

        stmt.execute();
        stmt.close();
        con.close();
    }

    public void atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, senha = ? WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getCpf());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getSenha());
        stmt.setInt(5, usuario.getId()); // Assuming you have a getId() method

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public Usuario getById(int id) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
        }

        rs.close();
        stmt.close();
        con.close();

        return usuario;
    }

    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        PreparedStatement stmt = con.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));

            usuarios.add(usuario);
        }

        rs.close();
        stmt.close();
        con.close();

        return usuarios;
    }
}
