public class Carro extends Veiculo {
    public Carro(String modelo, String fabricante, int anoFabricacao) throws Exception {
        super(modelo, fabricante, anoFabricacao, "Carro");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Tipo: " + getTipo());
    System.out.println("Modelo: " + getModelo());
    System.out.println("Fabricante: " + getFabricante());
    System.out.println("Ano de Fabricação: " + getAnoFabricacao());
    System.out.println("Status: " + getStatus());
    System.out.println("----------------------------");
    }
}
