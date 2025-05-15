public abstract class Veiculo {
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String status = "disponível";
    private String tipo;

    public Veiculo(String modelo, String fabricante, int anoFabricacao, String tipo) throws Exception {
        if (anoFabricacao > 2025) throw new Exception("Ano inválido.");
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public void vender() throws Exception {
        if (status.equals("vendido")) throw new Exception("Já foi vendido.");
        this.status = "vendido";
    }

    public abstract void exibirInfo();
}
