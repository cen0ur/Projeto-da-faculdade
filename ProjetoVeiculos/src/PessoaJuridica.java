public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String contato, String cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Pessoa Jurídica: " + getNome() + " - CNPJ: " + cnpj + " - Contato: " + getContato());
    }
}
