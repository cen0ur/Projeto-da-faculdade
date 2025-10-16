package model.entites;

import java.util.ArrayList;
import java.util.List;

public class Concessionaria {

    private String nome;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void cadastrarCliente(String tipoCliente, String nome, String contato, String documento) {
        if (tipoCliente.equals("pf")) {
            clientes.add(new PessoaFisica(nome, contato, documento));
        } else if (tipoCliente.equals("pj")) {
            clientes.add(new PessoaJuridica(nome, contato, documento));
        } else {
            System.out.println("Tipo de cliente inválido!");
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }
    public void cadastrarVeiculo(String tipo, String modelo, String fabricante, int ano) {
        try {
            Veiculo v = switch (tipo) {
                case "carro" -> new Carro(modelo, fabricante, ano);
                case "moto" -> new Moto(modelo, fabricante, ano);
                default -> throw new Exception("Tipo inválido.");
            };

            veiculos.add(v);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            v.exibirInfo();
        }
    }

    public void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            c.exibirInfo();
        }
    }

    public boolean deletarClientePorNome(String nome) {
        return clientes.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
    }

    public boolean deletarPorModelo(String modelo) {
        return veiculos.removeIf(v -> v.getModelo().equalsIgnoreCase(modelo));

    }

}
