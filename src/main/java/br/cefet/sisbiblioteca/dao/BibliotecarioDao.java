package br.cefet.sisbiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sisbiblioteca.model.Bibliotecario;

public class BibliotecarioDao {
    private Connection con;    
    
    public BibliotecarioDao() {
        con = ConnectionFactory.getConnection();
    }

    public void adicionar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "INSERT INTO bibliotecario (nome, cpf, email, senha, matricula) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, bibliotecario.getNome());
        stmt.setString(2, bibliotecario.getCpf());
        stmt.setString(3, bibliotecario.getEmail());
        stmt.setString(4, bibliotecario.getSenha());
        stmt.setString(5, bibliotecario.getMatricula());

        stmt.execute();
        stmt.close();
        con.close();
    }

    public void atualizar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "UPDATE bibliotecario SET nome = ?, cpf = ?, email = ?, senha = ?, matricula = ? WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, bibliotecario.getNome());
        stmt.setString(2, bibliotecario.getCpf());
        stmt.setString(3, bibliotecario.getEmail());
        stmt.setString(4, bibliotecario.getSenha());
        stmt.setString(5, bibliotecario.getMatricula());
        stmt.setInt(6, bibliotecario.getId());

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM bibliotecario WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public Bibliotecario getById(int id) throws SQLException {
        Bibliotecario bibliotecario = null;
        String sql = "SELECT * FROM bibliotecario WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            bibliotecario = new Bibliotecario();
            bibliotecario.setId(rs.getInt("id"));
            bibliotecario.setNome(rs.getString("nome"));
            bibliotecario.setCpf(rs.getString("cpf"));
            bibliotecario.setEmail(rs.getString("email"));
            bibliotecario.setSenha(rs.getString("senha"));
            bibliotecario.setMatricula(rs.getString("matricula"));
        }

        rs.close();
        stmt.close();
        con.close();

        return bibliotecario;
    }

    public List<Bibliotecario> getAll() throws SQLException {
        List<Bibliotecario> bibliotecarios = new ArrayList<>();
        String sql = "SELECT * FROM bibliotecario";

        PreparedStatement stmt = con.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Bibliotecario bibliotecario = new Bibliotecario();
            bibliotecario.setId(rs.getInt("id"));
            bibliotecario.setNome(rs.getString("nome"));
            bibliotecario.setCpf(rs.getString("cpf"));
            bibliotecario.setEmail(rs.getString("email"));
            bibliotecario.setSenha(rs.getString("senha"));
            bibliotecario.setMatricula(rs.getString("matricula"));

            bibliotecarios.add(bibliotecario);
        }

        rs.close();
        stmt.close();
        con.close();

        return bibliotecarios;
    }
    public Bibliotecario logar(String nome, String senha) throws SQLException {
        Bibliotecario bibliotecario = null;
        String sql = "SELECT * FROM bibliotecario WHERE nome = ? AND senha = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            bibliotecario = new Bibliotecario();
            bibliotecario.setId(rs.getInt("id"));
            bibliotecario.setNome(rs.getString("nome"));
            bibliotecario.setCpf(rs.getString("cpf"));
            bibliotecario.setEmail(rs.getString("email"));
            bibliotecario.setSenha(rs.getString("senha"));
            bibliotecario.setMatricula(rs.getString("matricula"));
        }

        rs.close();
        stmt.close();
        con.close();

        return bibliotecario;
    }
}
