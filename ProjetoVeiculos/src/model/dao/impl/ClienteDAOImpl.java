package model.dao.impl;

import db.ConexaoDb;
import model.dao.ClienteDAO;
import model.entities.Cliente;
import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void salvar(Cliente c) {
        String sql = "INSERT INTO cliente (nome, contato, documento, tipo) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexaoDb.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, c.getNome());
            ps.setString(2, c.getContato());
            ps.setString(3, c.getDocumento());
            ps.setString(4, c.getTipo());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    c.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY id";

        try (Connection con = ConexaoDb.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Cliente c;
                if ("pf".equalsIgnoreCase(tipo)) {
                    c = new PessoaFisica(rs.getString("nome"), rs.getString("contato"), rs.getString("documento"));
                } else {
                    c = new PessoaJuridica(rs.getString("nome"), rs.getString("contato"), rs.getString("documento"));
                }
                c.setId(rs.getInt("id"));
                lista.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage(), e);
        }

        return lista;
    }

    @Override
    public void deletarPorNome(String nome) {
        String sql = "DELETE FROM cliente WHERE nome = ?";

        try (Connection con = ConexaoDb.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar cliente: " + e.getMessage(), e);
        }
    }
}



