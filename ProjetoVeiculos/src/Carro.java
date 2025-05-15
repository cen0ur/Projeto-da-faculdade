public class Carro extends Veiculo {
    public Carro(String modelo, String fabricante, int anoFabricacao) throws Exception {
        super(modelo, fabricante, anoFabricacao, "Carro");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Carro - " + getTipo() + " - " + getStatus());
    }
}
