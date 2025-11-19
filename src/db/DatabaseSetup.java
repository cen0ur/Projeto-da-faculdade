package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void criarTabelas() {
        try (Connection con = ConexaoDb.getConnection();
             Statement st = con.createStatement()) {

            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS cliente (
                    id SERIAL PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    contato VARCHAR(50),
                    documento VARCHAR(50) UNIQUE NOT NULL,
                    tipo VARCHAR(5) NOT NULL
                );
            """);

        st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS veiculo (
                    id SERIAL PRIMARY KEY,
                    marca VARCHAR(50) NOT NULL,
                    modelo VARCHAR(50) NOT NULL,
                    ano INTEGER NOT NULL,
                    tipo VARCHAR(10) NOT NULL
                );
            """);

            System.out.println("Tabelas criadas/verificadas com sucesso!");

        }  catch (SQLException e) {
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}