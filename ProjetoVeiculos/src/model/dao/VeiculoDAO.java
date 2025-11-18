package model.dao;

import model.entities.Veiculo;
import java.util.List;

public interface VeiculoDAO {

    void salvar(Veiculo v);
    List<Veiculo> listar();
    void deletarPorModelo(String modelo);
}

