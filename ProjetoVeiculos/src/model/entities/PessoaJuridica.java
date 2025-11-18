package model.entities;

public class PessoaJuridica extends Cliente {

    public PessoaJuridica(String nome, String contato, String cnpj) {
        super(nome, contato, cnpj, "pj");
    }

    public void exibirInfo() {
        System.out.println("Pessoa Jurídica: " + getNome() + " - CNPJ: " + getDocumento() + " - Contato: " + getContato());
    }
}

