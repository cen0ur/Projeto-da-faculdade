package model.dao;

import model.entities.Cliente;
import java.util.List;

public interface ClienteDAO {

    void salvar(Cliente c);
    List<Cliente> listar();
    void deletarPorNome(String nome);
}


