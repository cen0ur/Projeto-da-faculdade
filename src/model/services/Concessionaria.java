package model.services;

import model.dao.ClienteDAO;
import model.dao.VeiculoDAO;
import model.dao.impl.ClienteDAOImpl;
import model.dao.impl.VeiculoDAOImpl;
import model.entities.*;

import java.util.List;

public class Concessionaria {

    private final VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    public void cadastrarVeiculo(String tipo, String marca, String modelo, int ano) {
        try {
            Veiculo v;
            if ("carro".equalsIgnoreCase(tipo)) {
                v = new Carro(marca, modelo, ano);
            } else if ("moto".equalsIgnoreCase(tipo)) {
                v = new Moto(marca, modelo, ano);
            } else {
                System.out.println("Tipo inválido. Use 'carro' ou 'moto'.");
                return;
            }
            veiculoDAO.salvar(v);
            System.out.println("Veículo salvo no banco!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
        }
    }

    public void cadastrarCliente(String tipo, String nome, String contato, String documento) {
        try {
            Cliente c;
            if ("pf".equalsIgnoreCase(tipo)) {
                c = new PessoaFisica(nome, contato, documento);
            } else if ("pj".equalsIgnoreCase(tipo)) {
                c = new PessoaJuridica(nome, contato, documento);
            } else {
                System.out.println("Tipo inválido. Use 'pf' ou 'pj'.");
                return;
            }
            clienteDAO.salvar(c);
            System.out.println("Cliente salvo no banco!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void exibirVeiculos() {
        List<Veiculo> lista = veiculoDAO.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum veículo encontrado.");
            return;
        }
        lista.forEach(System.out::println);
    }

    public void exibirClientes() {
        List<Cliente> lista = clienteDAO.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }
        lista.forEach(System.out::println);
    }

    public void deletarClientePorNome(String nome) {
        clienteDAO.deletarPorNome(nome);
        System.out.println("Operação de exclusão (cliente) executada.");
    }

    public void deletarPorModelo(String modelo) {
        veiculoDAO.deletarPorModelo(modelo);
        System.out.println("Operação de exclusão (veículo) executada.");
    }
}


