package model.entities;

public class PessoaFisica extends Cliente {

    public PessoaFisica(String nome, String contato, String cpf) {
        super(nome, contato, cpf, "pf");
    }

    public void exibirInfo() {
        System.out.println("Pessoa Física: " + getNome() + " - CPF: " + getDocumento() + " - Contato: " + getContato());
    }
}

