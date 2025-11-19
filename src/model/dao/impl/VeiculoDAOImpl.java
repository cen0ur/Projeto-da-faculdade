package model.dao.impl;

import db.ConexaoDb;
import model.dao.VeiculoDAO;
import model.entities.Carro;
import model.entities.Veiculo;
import model.entities.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAOImpl implements VeiculoDAO {

    @Override
    public void salvar(Veiculo v) {
        String sql = "INSERT INTO veiculo (marca, modelo, ano, tipo) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexaoDb.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, v.getMarca());
            ps.setString(2, v.getModelo());
            ps.setInt(3, v.getAno());
            ps.setString(4, v.getTipo());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    v.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar veículo: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Veiculo> listar() {
        List<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM veiculo ORDER BY id";

        try (Connection con = ConexaoDb.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Veiculo v;
                if ("carro".equalsIgnoreCase(tipo)) {
                    v = new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"));
                } else {
                    v = new Moto(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"));
                }
                v.setId(rs.getInt("id"));
                lista.add(v);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar veículos: " + e.getMessage(), e);
        }

        return lista;
    }

    @Override
    public void deletarPorModelo(String modelo) {
        String sql = "DELETE FROM veiculo WHERE modelo = ?";

        try (Connection con = ConexaoDb.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, modelo);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar veículo: " + e.getMessage(), e);
        }
    }
}




