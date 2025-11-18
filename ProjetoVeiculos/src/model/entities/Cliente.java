package model.entities;

public class Cliente {

    private int id;
    private String nome;
    private String contato;
    private String documento;
    private String tipo; // pf ou pj

    public Cliente() {}

    public Cliente(String nome, String contato, String documento, String tipo) {
        this.nome = nome;
        this.contato = contato;
        this.documento = documento;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public String getContato() {
        return contato;
    }
    public String getDocumento() {
        return documento;
    }
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format(
                """
                ─ Cliente #%d ─
                Tipo: %s
                Nome: %s
                Documento: %s
                Contato: %s
                """,
                getId(),
                tipo.equalsIgnoreCase("pf") ? "Pessoa Física" : "Pessoa Jurídica",
                nome,
                documento,
                contato
        );
    }
}



