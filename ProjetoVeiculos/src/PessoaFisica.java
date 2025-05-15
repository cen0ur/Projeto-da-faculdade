public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String contato, String cpf) {
        super(nome, contato);
        this.cpf = cpf;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Pessoa Física: " + getNome() + " - CPF: " + cpf + " - Contato: " + getContato());
    }
}
