package model.dao;

import model.entites.Veiculo;
import java.util.List;

public interface VeiculoDAO {
    void inserir(Veiculo v);
    List<Veiculo> listar();
    boolean deletarPorModelo(String modelo);
}
