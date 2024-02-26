package br.cefet.sisbiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sisbiblioteca.model.Genero;

public class GeneroDao {
    private Connection con;

    public GeneroDao() {
        con = ConnectionFactory.getConnection();
    }

    public void adicionar(Genero genero) throws SQLException {
        String sql = "INSERT INTO genero (nome) VALUES (?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, genero.getNome());

        stmt.execute();
        stmt.close();
        con.close();
    }

    public void atualizar(Genero genero) throws SQLException {
        String sql = "UPDATE genero SET nome = ? WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, genero.getNome());
        stmt.setInt(2, genero.getId());

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM genero WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public Genero getById(int id) throws SQLException {
        Genero genero = null;
        String sql = "SELECT * FROM genero WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            genero = new Genero();
            genero.setId(rs.getInt("id"));
            genero.setNome(rs.getString("nome"));
        }

        rs.close();
        stmt.close();
        con.close();

        return genero;
    }

    public List<Genero> getAll() throws SQLException {
        List<Genero> generos = new ArrayList<>();
        String sql = "SELECT * FROM genero";

        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Genero genero = new Genero();
            genero.setId(rs.getInt("id"));
            genero.setNome(rs.getString("nome"));

            generos.add(genero);
        }

        rs.close();
        stmt.close();
        con.close();

        return generos;
    }
}
