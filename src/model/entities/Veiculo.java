package model.entities;

public abstract class Veiculo {

    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String tipo;

    public Veiculo(String marca, String modelo, int ano, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAno() {
        return ano;
    }
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format(
                """
                ─ Veículo #%d ─
                Tipo: %s
                Marca: %s
                Modelo: %s
                Ano: %d
                """,
                getId(),
                tipo.equalsIgnoreCase("carro") ? "Carro" : "Moto",
                marca,
                modelo,
                ano
        );
    }
}


