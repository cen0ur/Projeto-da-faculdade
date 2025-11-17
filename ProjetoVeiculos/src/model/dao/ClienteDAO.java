package model.dao;

import model.entites.Cliente;
import java.util.List;

public interface ClienteDAO {
    void inserir(Cliente c);
    List<Cliente> listar();
    boolean deletarPorNome(String nome);
}

