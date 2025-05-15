public class Moto extends Veiculo {
    public Moto(String modelo, String fabricante, int anoFabricacao) throws Exception {
        super(modelo, fabricante, anoFabricacao, "Moto");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Moto - " + getTipo() + " - " + getStatus());
    }
}
